package br.com.kidelicia.dto;

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
public class TableDto extends EntityDto {
	
	private Integer number;

	@Override
	public void setDto(DomainEntity entity) {
		Table table = (Table) entity;
		
		this.number = table.getTableNumber();
	}

	@Override
	public DomainEntity getEntity() {
		return new Table(number);
	}


}
