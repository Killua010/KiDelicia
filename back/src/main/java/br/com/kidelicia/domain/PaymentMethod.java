package br.com.kidelicia.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_payment_method")
@AttributeOverride(name = "id", column = @Column(name = "pmt_pk"))
@AttributeOverride(name = "status", column = @Column(name = "pmt_status"))
@AttributeOverride(name = "name", column = @Column(name = "pmt_name"))
public class PaymentMethod extends NamedEntity {

}
