package br.com.kidelicia.strategy;

import br.com.kidelicia.domain.DomainEntity;

public interface IStrategy<entity extends DomainEntity> {
	public String execute(entity entity);
}
