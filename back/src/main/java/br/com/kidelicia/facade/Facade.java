package br.com.kidelicia.facade;

import java.lang.reflect.AnnotatedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kidelicia.dao.GenericDao;
import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.strategy.IStrategy;
import br.com.kidelicia.utils.Result;

@Service
public class Facade<entity extends DomainEntity> implements IFacade {

	@Autowired
	private GenericDao dao;

	@Autowired
	private List<IStrategy<entity>> strategys;

	private Result result;

	@Override
	public Result save(DomainEntity entity) {
		result = new Result();

		StringBuilder errors = executeStrategys(entity);

		if (errors.length() == 0) {
			result.getResultEntities().add(dao.save(entity));
			result.setHttpStatus(201);
		} else {
			result.setHttpStatus(400);
			result.getResultEntities().add(entity);
			result.setResponse(errors);
		}
		return result;

	}

	@Override
	public Result find(DomainEntity entity) {
		result = new Result();

		result.setResultEntities(dao.find(entity));

		if (result.getResultEntities().size() == 0) {
			result.setResponse(new StringBuilder("Entidade não encontrada"));
			result.setHttpStatus(404);
		} else {
			result.setHttpStatus(200);
		}

		return result;
	}

	@Override
	public Result update(DomainEntity entity) {
		result = new Result();

		StringBuilder errors = executeStrategys(entity);

		if (errors.length() == 0) {
			result.getResultEntities().add(dao.save(entity));
			result.setHttpStatus(204);
		} else {
			result.setHttpStatus(400);
			result.getResultEntities().add(entity);
			result.setResponse(errors);
		}
		return result;
	}

	@Override
	public Result delete(DomainEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	private StringBuilder executeStrategys(DomainEntity entity) {
		StringBuilder errors = new StringBuilder();

		for (IStrategy<entity> st : strategys) {
			for (AnnotatedType a : st.getClass().getAnnotatedInterfaces()) {
				if (a.getType().getTypeName().contains(entity.getClass().getName())) {
					errors.append(st.execute((entity) entity));
				}
			}
		}

		return errors;
	}

}
