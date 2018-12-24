package br.com.kidelicia.facade;

import java.lang.reflect.AnnotatedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kidelicia.dao.GenericDao;
import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.strategy.IStrategy;

@Service
public class Facade<entity extends DomainEntity> implements IFacade {
	
	@Autowired
	private GenericDao dao;
	
	@Autowired
	private List<IStrategy<entity>> strategys;

	@Override
	public String save(DomainEntity entity) {
		String errors = executeStrategys(entity); 
		
		if(errors.isEmpty()) {
			dao.save(entity);
			return "eae beleza";
		}
		return errors;
		
	}


	@Override
	public String find(DomainEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(DomainEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(DomainEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String executeStrategys(DomainEntity entity) {
		String errors = "";
		
		for(IStrategy<entity> st : strategys) {
			for(AnnotatedType a:st.getClass().getAnnotatedInterfaces()) {
				if(a.getType().getTypeName().contains(entity.getClass().getName())) {
					errors += st.execute((entity) entity);
				}
			}
		}
		
		return errors;
	}
	
	
}
