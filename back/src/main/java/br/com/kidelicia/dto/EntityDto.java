package br.com.kidelicia.dto;

import br.com.kidelicia.domain.DomainEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class EntityDto implements Idto{
	protected Long id;

	protected Boolean status;
}
