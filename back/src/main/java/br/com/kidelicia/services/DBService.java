package br.com.kidelicia.services;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.domain.Table;
import br.com.kidelicia.repository.TableRepository;

@Service
public class DBService {
	
	@Autowired
	private TableRepository tableRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		Table table1 = new Table(5);
		Table table2 = new Table(7);
		Table table3 = new Table(8);
		Table table4 = new Table(3);
		List<Table> tables = Arrays.asList(table1, table2, table3, table4);
		
		initializeEntity(tables);
		
		tableRepository.saveAll(tables);
	}

	private void initializeEntity(List<?> entities) {
		for(Object entity : entities) {
			((DomainEntity) entity).setCreationDate(LocalDateTime.now());
			((DomainEntity) entity).setLastUpdate(LocalDateTime.now());
		}
	}
	
}
