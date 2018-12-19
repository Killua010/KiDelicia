package br.com.kidelicia.domain;

import java.util.ArrayList;
import java.util.List;

public class Employee extends NamedEntity {

	private String register;

	private String cpf;

	private Occupation occupation;

	private List<Order> orders = new ArrayList<Order>();

}
