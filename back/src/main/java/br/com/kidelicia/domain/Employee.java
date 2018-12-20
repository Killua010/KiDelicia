package br.com.kidelicia.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "tb_employee")
@AttributeOverride(name = "id", column = @Column(name = "emp_pk"))
@AttributeOverride(name = "status", column = @Column(name = "emp_status"))
@AttributeOverride(name = "name", column = @Column(name = "emp_name"))
public class Employee extends NamedEntity {

	@Column(name = "emp_register")
	private String register;

	@Column(name = "emp_cpf")
	private String cpf;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ocu_emp_fk")
	private Occupation occupation;

	@OneToMany(mappedBy = "employee")
	private List<Order> orders = new ArrayList<Order>();

}
