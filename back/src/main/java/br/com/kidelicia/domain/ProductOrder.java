package br.com.kidelicia.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "tb_product_order")
@AttributeOverride(name = "id", column = @Column(name = "prd_pk"))
@AttributeOverride(name = "status", column = @Column(name = "prd_status"))
public class ProductOrder extends DomainEntity {
	
	@Column(name = "prd_quantity")
	private Integer quantity;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prd_pro_fk")
	private Product product;

}
