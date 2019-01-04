package br.com.kidelicia.facade;

import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.utils.Result;

public interface IFacade {
	
	public Result save(DomainEntity entity);
	public Result find(DomainEntity entity);
	public Result update(DomainEntity entity);
	public Result delete(DomainEntity entity);

}
