package br.com.kidelicia.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.repository.TableRepository;

@Service
public class SaveCommand extends AbstractCommand {

	@Override
	public String execute(DomainEntity entity) {
		return facade.save(entity);
	}

}
