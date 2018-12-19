package br.com.kidelicia.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IngredientProduct extends NamedEntity {

	private Integer quantity;

	private Ingredient ingredient;

}
