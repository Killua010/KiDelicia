package br.com.kidelicia.facade;

import br.com.kidelicia.domain.DomainEntity;

public interface IFacade {
	
	public String save(DomainEntity entity);
	public String find(DomainEntity entity);
	public String update(DomainEntity entity);
	public String delete(DomainEntity entity);

}
