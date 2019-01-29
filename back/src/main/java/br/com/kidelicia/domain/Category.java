package br.com.kidelicia.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_category")
@AttributeOverride(name = "id", column = @Column(name = "cat_pk"))
@AttributeOverride(name = "status", column = @Column(name = "cat_status"))
@AttributeOverride(name = "name", column = @Column(name = "cat_name"))
public class Category extends NamedEntity {

	@OneToMany(mappedBy = "category")
	private Set<Product> products = new HashSet<Product>();
	
	public Category(String name) {
		super(name);
	}

	public Category(String name, Long id, Boolean status) {
		super(name, id, status);
	}

}
