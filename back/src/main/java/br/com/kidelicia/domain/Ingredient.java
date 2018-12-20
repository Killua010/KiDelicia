package br.com.kidelicia.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ingredient")
@AttributeOverride(name = "id", column = @Column(name = "ing_pk"))
@AttributeOverride(name = "status", column = @Column(name = "ing_status"))
@AttributeOverride(name = "name", column = @Column(name = "ing_name"))
public class Ingredient extends NamedEntity {

}
