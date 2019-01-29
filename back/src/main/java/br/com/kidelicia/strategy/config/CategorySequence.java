package br.com.kidelicia.strategy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.kidelicia.domain.Category;
import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.domain.Table;
import br.com.kidelicia.strategy.IStrategy;
import br.com.kidelicia.strategy.Sequence;
import br.com.kidelicia.strategy.category.StCategoryValidateExistence;
import br.com.kidelicia.strategy.standard.StLastUpdate;
import br.com.kidelicia.strategy.standard.StRegistrationDate;
import br.com.kidelicia.strategy.table.StTableValidateExistence;

@Configuration
public class CategorySequence {

	@Autowired
	StCategoryValidateExistence stCategoryValidateExistence;
	
	@Autowired
	StRegistrationDate stRegistrationDate;
	
	@Autowired
	StLastUpdate stLastUpdate;

	@Bean("SAVE_CATEGORY")
	public Sequence<Category> savetABLE() {
		return new Sequence<Category>()
				.add(stCategoryValidateExistence)
				.add(stRegistrationDate);
	}
	
	@Bean("UPDATE_CATEGORY")
	public Sequence<Category> updateTable() {
		return new Sequence<Category>()
				.add(stCategoryValidateExistence)
				.add(stLastUpdate);
	}

}
