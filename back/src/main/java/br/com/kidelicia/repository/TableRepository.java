package br.com.kidelicia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.kidelicia.domain.Table;

@Repository
public interface TableRepository extends IRepository<Table> {
	
	@Query("SELECT table FROM Table table WHERE TRUE = table.status AND table.tableNumber = ?1")
	Optional<Table> findActiveByNumberTable(Integer number);
}
