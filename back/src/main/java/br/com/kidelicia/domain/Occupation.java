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
@Table(name = "tb_occupation")
@AttributeOverride(name = "id", column = @Column(name = "ocu_pk"))
@AttributeOverride(name = "status", column = @Column(name = "ocu_status"))
@AttributeOverride(name = "name", column = @Column(name = "ocu_name"))
public class Occupation extends NamedEntity {

	@OneToMany(mappedBy = "occupation")
	private List<Employee> employee = new ArrayList<Employee>();

}
