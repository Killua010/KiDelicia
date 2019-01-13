package br.com.kidelicia.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.kidelicia.command.ICommand;
import br.com.kidelicia.controller.utils.StandardResponse;
import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.dto.EntityDto;
import br.com.kidelicia.utils.Result;

@RestController
public abstract class AbstractController <dto extends EntityDto> {
	
	@Autowired
	private List<ICommand> commands;
	
	@Autowired
	private StandardResponse standardResponse;
	
	
	@PostMapping
    public @ResponseBody ResponseEntity<Result> save(@RequestBody dto entity){
		return restResponse(searchCommand("Save").execute(entity.getEntity()));
    }
	
	@GetMapping({"", "/{id}"})
    public @ResponseBody ResponseEntity<Result> findAll(@RequestBody dto entity, @PathVariable(value="id",required=false) Long id){
		return restResponse(searchCommand("Find").execute(entity.getEntity(id, null)));
    }
	
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<Result> update(@RequestBody dto entity, @PathVariable Long id){
		return restResponse(searchCommand("Update").execute(entity.getEntity(id, null)));
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Result> delete(@RequestBody dto entity, @PathVariable Long id){
		return restResponse(searchCommand("Delete").execute(entity.getEntity(id, null)));
	}
	
	
	private ICommand searchCommand(String operation) {
		ICommand command = null;
		for(ICommand cmd : commands) {
			command = (cmd.getClass().getName().toUpperCase().contains(operation.toUpperCase())) ? cmd : command;	
		}
		return command;
	}
	
	private ResponseEntity<Result> restResponse(Result result){
		
		for(Method method : this.standardResponse.getClass().getMethods()) {
			if(method.getName().contains(result.getHttpStatus().toString())) {
				try {
					return (ResponseEntity<Result>) method.invoke(this.standardResponse, result);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
}
