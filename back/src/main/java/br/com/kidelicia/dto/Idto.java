package br.com.kidelicia.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.kidelicia.domain.DomainEntity;

public interface Idto {
	
	List<EntityDto> getListDto(List<DomainEntity> entities);
	
	@JsonIgnore
	DomainEntity getEntity();
}
