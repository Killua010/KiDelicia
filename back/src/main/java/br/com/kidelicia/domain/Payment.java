package br.com.kidelicia.domain;

public class Payment extends DomainEntity {

	private Float amount;

	private PaymentMethod paymentMethod;

	private Order order;

}
