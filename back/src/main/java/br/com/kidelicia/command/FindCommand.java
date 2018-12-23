package br.com.kidelicia.command;

import br.com.kidelicia.domain.DomainEntity;

public class FindCommand extends AbstractCommand {

	@Override
	public String execute(DomainEntity entity) {
		return facade.find(entity);
	}

}
