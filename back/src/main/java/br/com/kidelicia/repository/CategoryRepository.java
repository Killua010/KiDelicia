package br.com.kidelicia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.kidelicia.domain.Category;
import br.com.kidelicia.domain.Table;

@Repository
public interface CategoryRepository extends IRepository<Category> {

	@Query("SELECT category FROM Category category WHERE TRUE = category.status AND category.name = ?1")
	Optional<Category> findActiveByNameCategory(String name);
	
}
