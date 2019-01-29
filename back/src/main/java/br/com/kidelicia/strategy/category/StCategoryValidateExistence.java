package br.com.kidelicia.strategy.category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kidelicia.domain.Category;
import br.com.kidelicia.repository.CategoryRepository;
import br.com.kidelicia.repository.CategoryRepository;
import br.com.kidelicia.strategy.IStrategy;

@Service
public class StCategoryValidateExistence implements IStrategy<Category> {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public String execute(Category entity) {
		Optional<Category> optionalCategory = categoryRepository.findActiveByNameCategory(entity.getName());
		
		if(optionalCategory.isPresent()) {
			if(!optionalCategory.get().getId().equals(entity.getId())) {
				return "Categoria já cadastrada no sistema";
			}
		}
		return "";
	}



}
