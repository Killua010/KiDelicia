package br.com.kidelicia.strategy;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kidelicia.domain.Table;
import br.com.kidelicia.repository.TableRepository;

@Service
public class StTableValidateExistence implements IStrategy<Table> {

	@Autowired
	private TableRepository tableRepository;
	
	@Override
	public String execute(Table entity) {
		Optional<Table> optionalTable = tableRepository.findActiveByNumberTable(entity.getTableNumber());
		
		if(optionalTable.isPresent()) {
			return "Mesa já cadastrada no sistema";
		}
		return "";
	}



}
