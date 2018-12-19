package br.com.kidelicia.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order extends DomainEntity {

	private LocalDateTime dateTime;

	private OrderStatus orderStatus;

	private List<ProductOrder> productOrder = new ArrayList<ProductOrder>();

	private Payment payment;

	private Table table;

	private Employee employee;

}
