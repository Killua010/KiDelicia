package br.com.kidelicia.controller.utils;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.kidelicia.domain.DomainEntity;
import br.com.kidelicia.dto.EntityDto;
import br.com.kidelicia.dto.Idto;
import br.com.kidelicia.utils.Result;

@Component
public class StandardResponse <dto extends EntityDto>{
	
	@Autowired
	private List<Idto> dtos;
	
	public ResponseEntity<?> Status200(Result result){
		Idto idto = searchDto(result.getResultEntities().get(0));
		return ResponseEntity.ok().body(idto.getListDto(result.getResultEntities()));
	}
	
	public ResponseEntity<?> Status201(Result result){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getResultEntities().get(0).getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	public ResponseEntity<?> Status400(Result result){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getResponse());
	}
	
	public ResponseEntity<?> Status404(Result result){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result.getResponse());
	}
	
	
	private Idto searchDto(DomainEntity entity){
		for (Idto dto : this.dtos) {
			if(dto.getClass().getName().toLowerCase().contains(entity.getClass().getSimpleName().toLowerCase())) {
				return dto;
			}
		}
		return null;
	}
	
}
