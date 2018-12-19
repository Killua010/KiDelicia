package br.com.kidelicia.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product extends NamedEntity {

	private Float valor;

	private String descricao;

	private Category category;

	private Set<IngredientProduct> ingredientsProduct = new HashSet<IngredientProduct>();

}
