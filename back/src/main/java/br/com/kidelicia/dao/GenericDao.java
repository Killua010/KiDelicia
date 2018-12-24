package br.com.kidelicia.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.repository.IRepository;

@Service
@Transactional
public class GenericDao<entity extends DomainEntity> implements IDao<DomainEntity>{
	
	@Autowired
	private Map<String, IRepository<entity>> repositories;

	@Override
	public DomainEntity save(DomainEntity entity) {
		return searchRepository(entity).save((entity) entity);
	}

	@Override
	public List<DomainEntity> find(DomainEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DomainEntity update(DomainEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(DomainEntity entity) {
		// TODO Auto-generated method stub
		
	}
	
	private IRepository<entity> searchRepository(DomainEntity entity){
		for (Entry<String, IRepository<entity>> e : repositories.entrySet()) {
			if(e.getKey().toLowerCase()
				.equals(entity.getClass().getSimpleName().concat("Repository").toLowerCase())) {
				return e.getValue();
			}
		}
		return null;
	}
	
}
