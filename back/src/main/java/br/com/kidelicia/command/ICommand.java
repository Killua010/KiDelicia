package br.com.kidelicia.command;

import br.com.kidelicia.domain.DomainEntity;

public interface ICommand {
	public String execute(DomainEntity entity);
}
