package br.com.kidelicia.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.kidelicia.domain.DomainEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Result {
	
	private Integer httpStatus;
	private StringBuilder Response;
	private List<DomainEntity> resultEntities = new ArrayList<>();
	
}
