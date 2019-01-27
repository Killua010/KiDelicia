package br.com.kidelicia.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
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
	
	@NotNull(message="O campo numero é obrigatório")
	@Min(value = 1, message="Insira um valor inteiro positivo")
	private Integer number;

	@Override
	public DomainEntity getEntity() {
		return new Table(number);
	}
	
	@Override
	public DomainEntity getEntity(Long id) {
		Boolean status = (null == this.status) ? null : this.status;
		return new Table(number, id, status);
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
