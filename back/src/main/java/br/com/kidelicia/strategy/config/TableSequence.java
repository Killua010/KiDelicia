package br.com.kidelicia.strategy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.domain.Table;
import br.com.kidelicia.strategy.IStrategy;
import br.com.kidelicia.strategy.Sequence;
import br.com.kidelicia.strategy.standard.StLastUpdate;
import br.com.kidelicia.strategy.standard.StRegistrationDate;
import br.com.kidelicia.strategy.table.StTableValidateExistence;

@Configuration
public class TableSequence {

	@Autowired
	StTableValidateExistence stTableValidateExistence;
	
	@Autowired
	StRegistrationDate stRegistrationDate;
	
	@Autowired
	StLastUpdate stLastUpdate;

	@Bean("SAVE_TABLE")
	public Sequence<Table> savetABLE() {
		return new Sequence<Table>()
				.add(stTableValidateExistence)
				.add(stRegistrationDate);
	}
	
	@Bean("UPDATE_TABLE")
	public Sequence<Table> updateTable() {
		return new Sequence<Table>()
				.add(stTableValidateExistence)
				.add(stLastUpdate);
	}

}
