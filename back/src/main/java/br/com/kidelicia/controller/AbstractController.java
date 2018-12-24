package br.com.kidelicia.controller;

import java.lang.reflect.AnnotatedType;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.kidelicia.command.ICommand;
import br.com.kidelicia.dto.EntityDto;
import br.com.kidelicia.dto.Idto;
import br.com.kidelicia.repository.TableRepository;

@RestController
public abstract class AbstractController <dto extends EntityDto> {
	
	@Autowired
	private List<ICommand> commands;
	
	
	@PostMapping
    public @ResponseBody String save(@RequestBody dto entity){
		return searchCommand("Save").execute(entity.getEntity());
    }
	
	private ICommand searchCommand(String operation) {
		ICommand command = null;
		for(ICommand cmd : commands) {
			command = (cmd.getClass().getName().toUpperCase().contains(operation.toUpperCase())) ? cmd : command;	
		}
		return command;
	}
	
}
