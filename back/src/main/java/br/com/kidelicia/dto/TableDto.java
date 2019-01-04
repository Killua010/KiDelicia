package br.com.kidelicia.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.domain.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class TableDto extends EntityDto {
	
	private Integer number;

	@Override
	public DomainEntity getEntity() {
		return new Table(number);
	}

	@Override
	public List<EntityDto> getListDto(List<DomainEntity> entities) {
		List<EntityDto> dtos = new ArrayList<EntityDto>();
		for(DomainEntity entity : entities) {
			TableDto dto = new TableDto();
			dto.setNumber(((Table)entity).getTableNumber());
			dto.setId(((Table)entity).getId());
			dto.setStatus(((Table)entity).getStatus());
			dtos.add(dto);
		}
		return dtos;
	}


}
