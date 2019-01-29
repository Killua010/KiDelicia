package br.com.kidelicia.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.kidelicia.command.ICommand;
import br.com.kidelicia.controller.utils.HttpResponseEntity;
import br.com.kidelicia.dto.EntityDto;
import br.com.kidelicia.utils.Result;

@CrossOrigin
@RestController
public abstract class AbstractController<dto extends EntityDto> {

	@Autowired
	private dto entity;

	@Autowired
	private List<ICommand> commands;

	@Autowired
	private HttpResponseEntity standardResponse;

	@PostMapping
	public @ResponseBody ResponseEntity<Result> save(@Valid @RequestBody dto entity) {
		Result result = searchCommand("Save").execute(entity.getEntity());
		if (null != result.getResponse() && !result.getResponse().toString().isEmpty()) {
			result.setHttpStatus(400);
		} else {
			result.setHttpStatus(201);
		}
		return restResponse(result);
	}

	@GetMapping({"", "/{id}"})
    public @ResponseBody ResponseEntity<Result> find(@PathVariable(value="id",required=false) Long id){
		entity = createEntity();
		Result result = searchCommand("Find").execute(entity.getEntity(id));
		if(null != result.getResponse() && !result.getResponse().toString().isEmpty()) {
			result.setHttpStatus(404);
		} else {
			result.setHttpStatus(200);
		}
		return restResponse(result);
    }

	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<Result> update(@Valid @RequestBody dto entity, @PathVariable Long id) {
		Result result = searchCommand("Update").execute(entity.getEntity(id));
		if (null != result.getResponse() && !result.getResponse().toString().isEmpty()) {
			result.setHttpStatus(400);
		} else {
			result.setHttpStatus(200);
		}
		return restResponse(result);
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Result> delete(@PathVariable Long id) {
		entity = createEntity();
		Result result = searchCommand("Delete").execute(entity.getEntity(id));
		result.setHttpStatus(204);
		return restResponse(result);
	}

	private dto createEntity() {
		Object object = null;
		try {
			Class classDefinition = Class.forName(entity.getClass().getName());
			object = classDefinition.newInstance();
		} catch (Exception e) {
			System.out.println(e);
		}
		return (dto) object;
	}

	private ICommand searchCommand(String operation) {
		ICommand command = null;
		for (ICommand cmd : commands) {
			command = (cmd.getClass().getName().toUpperCase().contains(operation.toUpperCase())) ? cmd : command;
		}
		return command;
	}

	private ResponseEntity<Result> restResponse(Result result) {

		for (Method method : this.standardResponse.getClass().getMethods()) {
			if (method.getName().contains(result.getHttpStatus().toString())) {
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
