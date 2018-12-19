package br.com.kidelicia.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment extends DomainEntity {

	private Float amount;

	private PaymentMethod paymentMethod;

	private Order order;

}
