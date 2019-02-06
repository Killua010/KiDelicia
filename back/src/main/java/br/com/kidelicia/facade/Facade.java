package br.com.kidelicia.facade;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kidelicia.dao.GenericDao;
import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.strategy.IStrategy;
import br.com.kidelicia.strategy.Sequence;
import br.com.kidelicia.utils.Result;

@Service
public class Facade<entity extends DomainEntity> implements IFacade {
	
	@Autowired
	private Map<String, Sequence<entity>> listNavigations = new HashMap<String, Sequence<entity>>();
	
	@Autowired
	private GenericDao dao;

	private Result result;

	@Override
	public Result save(DomainEntity entity) {
		
		result = new Result();

		StringBuilder errors = runStrategys(entity, "Save");

		if (errors.length() == 0) {
			result.getResultEntities().add(dao.save(entity));
		} else {
			result.setResponse(errors);
		}
		return result;

	}

	@Override
	public Result find(DomainEntity entity) {
		result = new Result();
		result.setResultEntities(dao.find(entity));
		if (null != entity.getId() && (result.getResultEntities().size() == 0 || null == result.getResultEntities().get(0))) {
			result.setResponse(new StringBuilder("Entidade não encontrada"));	
		}
		
		return result;
	}

	@Override
	public Result update(DomainEntity entity) {
		result = new Result();

		DomainEntity newEntity = (DomainEntity) dao.find(entity).get(0);
		entity.setStatus((null == entity.getStatus()) ? newEntity.getStatus() : entity.getStatus());
		
		StringBuilder errors = runStrategys(entity, "Update");

		if (errors.length() == 0) {
			result.getResultEntities().add(dao.save(entity));
		} else {
			result.getResultEntities().add(entity);
			result.setResponse(errors);
		}
		return result;
	}

	@Override
	public Result delete(DomainEntity entity) {
		result = new Result();
		dao.delete(entity);
		return result;
	}

	private StringBuilder runStrategys(DomainEntity entity, String operation) {
		StringBuilder errors = new StringBuilder();

		listNavigations.entrySet().forEach(strategy -> {
			if(strategy.getKey().toLowerCase()
					.equals(operation.concat("_").concat(entity.getClass().getSimpleName()).toLowerCase())) {
				strategy.getValue().getIStrategies().forEach(iStr -> errors.append(iStr.execute((entity) entity)));
			}
		});

		return errors;
	}

}
