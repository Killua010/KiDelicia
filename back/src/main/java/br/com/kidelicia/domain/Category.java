package br.com.kidelicia.domain;

import java.util.HashSet;
import java.util.Set;

public class Category extends NamedEntity {

	private Set<Product> products = new HashSet<Product>();

}
