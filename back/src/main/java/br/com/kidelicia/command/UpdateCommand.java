package br.com.kidelicia.command;

import org.springframework.stereotype.Service;

import br.com.kidelicia.domain.DomainEntity;

@Service
public class UpdateCommand extends AbstractCommand {

	@Override
	public String execute(DomainEntity entity) {
		return facade.update(entity);
	}

}
