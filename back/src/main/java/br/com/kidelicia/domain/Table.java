package br.com.kidelicia.domain;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@javax.persistence.Table(name="tb_table")
@AttributeOverride(name = "id", column = @Column(name = "tbl_pk"))
@AttributeOverride(name = "status", column = @Column(name = "tbl_status"))
public class Table extends DomainEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "tbl_table_number")
	private Integer tableNumber;
	
	public Table(Integer number, Long id, Boolean status) {
		super(id, status);
		this.tableNumber = number;
	}
	

}
