package br.com.kidelicia.strategy.table;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kidelicia.domain.Table;
import br.com.kidelicia.repository.TableRepository;
import br.com.kidelicia.strategy.IStrategy;

@Service
public class StTableValidateExistence implements IStrategy<Table> {

	@Autowired
	private TableRepository tableRepository;
	
	@Override
	public String execute(Table entity) {
		Optional<Table> optionalTable = tableRepository.findActiveByNumberTable(entity.getTableNumber());
		
		if(optionalTable.isPresent()) {
			if(!optionalTable.get().getId().equals(entity.getId())) {
				return "Mesa já cadastrada no sistema";
			}
		}
		return "";
	}



}
