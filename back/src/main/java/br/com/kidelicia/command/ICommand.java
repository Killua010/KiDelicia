package br.com.kidelicia.command;

import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.utils.Result;

public interface ICommand {
	public Result execute(DomainEntity entity);
}
