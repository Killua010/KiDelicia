package br.com.kidelicia.command;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.kidelicia.facade.Facade;
import br.com.kidelicia.facade.IFacade;

public abstract class AbstractCommand implements ICommand {
	
	@Autowired
	protected IFacade facade;
}
