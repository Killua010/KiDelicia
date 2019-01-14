package br.com.kidelicia.strategy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.kidelicia.domain.DomainEntity;
import lombok.Getter;

@Getter
@Component
public class Sequence <entity extends DomainEntity>{
	private List<IStrategy<entity>> iStrategies;

	public Sequence() {
		this.iStrategies = new ArrayList<IStrategy<entity>>();
	}
	
	public Sequence add(IStrategy<entity> iStrategy) {
		this.iStrategies.add(iStrategy);
		return this;
	}
	
}
