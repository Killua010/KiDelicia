package br.com.kidelicia.domain;

import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class NamedEntity extends DomainEntity {

	private String name;
	
	public NamedEntity(String name, Long id, Boolean status) {
		super(id, status);
		this.name = name;
	}

}
