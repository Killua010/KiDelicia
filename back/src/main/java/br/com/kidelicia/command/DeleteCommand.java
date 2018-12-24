package br.com.kidelicia.command;

import org.springframework.stereotype.Service;

import br.com.kidelicia.domain.DomainEntity;

@Service
public class DeleteCommand extends AbstractCommand {

	@Override
	public String execute(DomainEntity entity) {
		return facade.delete(entity);
	}

}
