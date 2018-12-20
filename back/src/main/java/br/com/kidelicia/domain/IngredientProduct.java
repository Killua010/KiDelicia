package br.com.kidelicia.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "tb_ingredient_product")
@AttributeOverride(name = "id", column = @Column(name = "igp_pk"))
@AttributeOverride(name = "status", column = @Column(name = "igp_status"))
public class IngredientProduct extends DomainEntity {

	@Column(name = "igp_quantity")
	private Integer quantity;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "igp_ing_fk")
	private Ingredient ingredient;

}
