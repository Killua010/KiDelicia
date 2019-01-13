package br.com.kidelicia.strategy.standard;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.strategy.IStrategy;

@Service
public class StLastUpdate implements IStrategy<DomainEntity> {

	@Override
	public String execute(DomainEntity entity) {
		entity.setLastUpdate(LocalDateTime.now());
		return "";
	}

}
