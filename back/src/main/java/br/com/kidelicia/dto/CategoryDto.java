package br.com.kidelicia.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import br.com.kidelicia.domain.Category;
import br.com.kidelicia.domain.DomainEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class CategoryDto extends EntityDto {
	
	@NotNull(message="O nome da categoria é obrigatório")
	@NotEmpty(message="O nome da categoria é obrigatório")
	private String name;

	@Override
	public DomainEntity getEntity() {
		return new Category(name);
	}
	
	@Override
	public DomainEntity getEntity(Long id) {
		Boolean status = (null == this.status) ? null : this.status;
		return new Category(name, id, status);
	}

	@Override
	public List<EntityDto> getListDto(List<DomainEntity> entities) {
		List<EntityDto> dtos = new ArrayList<EntityDto>();
		for(DomainEntity entity : entities) {
			CategoryDto dto = new CategoryDto();
			dto.setName(((Category)entity).getName());
			dto.setId(((Category)entity).getId());
			dto.setStatus(((Category)entity).getStatus());
			dtos.add(dto);
		}
		return dtos;
	}

}
