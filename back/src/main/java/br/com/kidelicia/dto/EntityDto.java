package br.com.kidelicia.dto;

import br.com.kidelicia.domain.DomainEntity;

public abstract class EntityDto implements Idto<DomainEntity>{
	protected Long id;

	protected Boolean status;
}
