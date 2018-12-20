package br.com.kidelicia.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
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
@Table(name = "tb_payment")
@AttributeOverride(name = "id", column = @Column(name = "pay_pk"))
@AttributeOverride(name = "status", column = @Column(name = "pay_status"))
public class Payment extends DomainEntity {
	
	@Column(name = "pay_amount")
	private Float amount;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pay_pmt_fk")
	private PaymentMethod paymentMethod;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pay_ord_fk")
	private Order order;

}
