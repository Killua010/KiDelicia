package br.com.kidelicia.command;

import br.com.kidelicia.facade.Facade;
import br.com.kidelicia.facade.IFacade;

public abstract class AbstractCommand implements ICommand {
	protected IFacade facade = new Facade();
}
