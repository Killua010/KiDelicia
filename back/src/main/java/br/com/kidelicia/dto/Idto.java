package br.com.kidelicia.dto;

import br.com.kidelicia.domain.DomainEntity;

public interface Idto <Entity extends DomainEntity> {
	
	public void setObject(Entity entity);
	
	public Entity setDto();
}
