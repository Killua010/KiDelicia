package br.com.kidelicia.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_product")
@AttributeOverride(name = "id", column = @Column(name = "pro_pk"))
@AttributeOverride(name = "status", column = @Column(name = "pro_status"))
@AttributeOverride(name = "name", column = @Column(name = "pro_name"))
public class Product extends NamedEntity {
	
	@Column(name = "pro_value")
	private Float value;

	@Column(name = "pro_description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pro_cat_fk")
	private Category category;

	@JoinTable(name = "tb_product_ingredient_product", joinColumns = {
			@JoinColumn(name = "pro_fk", referencedColumnName = "pro_pk") }, inverseJoinColumns = {
					@JoinColumn(name = "igp_fk", referencedColumnName = "igp_pk") })
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<IngredientProduct> ingredientsProduct = new HashSet<IngredientProduct>();

}
