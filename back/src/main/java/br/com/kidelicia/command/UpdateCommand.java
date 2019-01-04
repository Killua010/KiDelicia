package br.com.kidelicia.command;

import org.springframework.stereotype.Service;

import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.utils.Result;

@Service
public class UpdateCommand extends AbstractCommand {

	@Override
	public Result execute(DomainEntity entity) {
		return facade.update(entity);
	}

}
