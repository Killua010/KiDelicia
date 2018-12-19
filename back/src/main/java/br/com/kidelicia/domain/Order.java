package br.com.kidelicia.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order extends DomainEntity {

	private LocalDateTime dateTime;

	private OrderStatus orderStatus;

	private List<ProductOrder> productOrder = new ArrayList<ProductOrder>();

	private Payment payment;

	private Table table;

	private Employee employee;

}
