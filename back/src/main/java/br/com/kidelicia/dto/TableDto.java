package br.com.kidelicia.dto;

import br.com.kidelicia.domain.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TableDto extends EntityDto implements Idto<Table> {
	
	private Integer number;

	@Override
	public void setObject(Table entity) {
		entity.setTableNumber(number);
	}

	@Override
	public Table setDto() {
		return new Table(number);
	}

}
