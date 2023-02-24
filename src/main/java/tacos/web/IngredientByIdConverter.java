package tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.Ingredient;

import tacos.data.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
	@Autowired
	private IngredientRepository ingredientRepo;

	@Override
	public Ingredient convert(String id) {
		return ingredientRepo.findById(id).orElse(null);
	}
}