package br.com.kidelicia.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kidelicia.dao.GenericDao;
import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.domain.Table;
import br.com.kidelicia.repository.TableRepository;

@Service
public class Facade implements IFacade {
	
	@Autowired
	private GenericDao dao;
	
//	@Autowired
//	private TableRepository repository;

	@Override
	public String save(DomainEntity entity) {
		dao.save(entity);
		return "eae beleza";
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
	
}
