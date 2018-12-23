package br.com.kidelicia.controller;

import java.lang.reflect.Field;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.kidelicia.dto.EntityDto;

@RestController
public abstract class AbstractController <dto extends EntityDto> {
	
	@PostMapping
    public @ResponseBody String save(@RequestBody dto entity){		
		return "Sucesso";
    }
	
}
