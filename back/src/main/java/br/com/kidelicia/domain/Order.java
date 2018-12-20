package br.com.kidelicia.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@javax.persistence.Table(name = "tb_order")
@AttributeOverride(name = "id", column = @Column(name = "ord_pk"))
@AttributeOverride(name = "status", column = @Column(name = "ord_status"))
public class Order extends DomainEntity {
	
	@Column(name = "ord_date_time")
	private LocalDateTime dateTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ord_ors_fk")
	private OrderStatus orderStatus;

	@JoinTable(name = "tb_order_product_order", joinColumns = {
			@JoinColumn(name = "ord_fk", referencedColumnName = "ord_pk") }, inverseJoinColumns = {
					@JoinColumn(name = "prd_fk", referencedColumnName = "prd_pk") })
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProductOrder> productOrder = new ArrayList<ProductOrder>();

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ord_tbl_fk")
	private Table table;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ord_emp_fk")
	private Employee employee;

}
