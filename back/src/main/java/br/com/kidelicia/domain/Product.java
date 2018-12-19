package br.com.kidelicia.domain;

import java.util.HashSet;
import java.util.Set;

public class Product extends NamedEntity {

	private Float valor;

	private String descricao;

	private Category category;

	private Set<IngredientProduct> ingredientsProduct = new HashSet<IngredientProduct>();

}
