package br.com.kidelicia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kidelicia.domain.Table;

@Repository
public interface TableRepository extends IRepository<Table> {

}
