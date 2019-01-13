package br.com.kidelicia.strategy.standard;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.strategy.IStrategy;

@Service
public class StRegistrationDate implements IStrategy<DomainEntity> {

	@Override
	public String execute(DomainEntity entity) {
		entity.setCreationDate(LocalDateTime.now());
		entity.setLastUpdate(LocalDateTime.now());
		return "";
	}

}
