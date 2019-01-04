package br.com.kidelicia.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.kidelicia.domain.DomainEntity;

public interface Idto {
	
	public List<EntityDto> getListDto(List<DomainEntity> entities);
	
	@JsonIgnore
	public DomainEntity getEntity();
}
