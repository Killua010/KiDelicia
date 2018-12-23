package br.com.kidelicia.command;

import br.com.kidelicia.domain.DomainEntity;

public class SaveCommand extends AbstractCommand {

	@Override
	public String execute(DomainEntity entity) {
		return facade.save(entity);
	}

}
