package br.com.kidelicia.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tb_order_status")
@AttributeOverride(name = "id", column = @Column(name = "ors_pk"))
@AttributeOverride(name = "status", column = @Column(name = "ors_status"))
@AttributeOverride(name = "name", column = @Column(name = "ors_name"))
public class OrderStatus extends NamedEntity {
	
	@OneToMany(mappedBy = "orderStatus")
	private List<Order> orders = new ArrayList<Order>();

}
