package br.com.kidelicia.command;

import org.springframework.stereotype.Service;

import br.com.kidelicia.domain.DomainEntity;

@Service
public class FindCommand extends AbstractCommand {

	@Override
	public String execute(DomainEntity entity) {
		return facade.find(entity);
	}

}
