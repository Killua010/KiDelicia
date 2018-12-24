package br.com.kidelicia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kidelicia.domain.DomainEntity;

public interface IDao<entity extends DomainEntity> {
	
	public DomainEntity save(DomainEntity entity);
	public List<DomainEntity> find(DomainEntity entity);
	public DomainEntity update(DomainEntity entity);
	public void delete(DomainEntity entity);

}
