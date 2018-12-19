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
public class Category extends NamedEntity {

	private Set<Product> products = new HashSet<Product>();

}
