package com.coderscampus.Assignment9.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.coderscampus.Assignment9.domain.Recipe;

@Service
public class RecipeService {
	private List<Recipe> recipes = new ArrayList<>();
	private FileService fileservice = new FileService();

	public List<Recipe> getVegetarian() {
		   return getAllRecipes().stream().filter(recipe -> recipe.getVegetarian()).collect(Collectors.toList());
	}
	public List<Recipe> getVegan() {
		   return getAllRecipes().stream().filter(recipe -> recipe.getVegan()).collect(Collectors.toList());
	}
	public List<Recipe> getGlutenFree() {
		                return getAllRecipes().stream().filter(recipe -> recipe.getGlutenFree()).collect(Collectors.toList());
	}
	public List<Recipe> getVeganAndGlutenFree() {
		   return getAllRecipes().stream().filter(recipe -> recipe.getGlutenFree() && recipe.getVegan()).collect(Collectors.toList());
	}
	public List<Recipe> getAllRecipes() {
		if (CollectionUtils.isEmpty(recipes)) {
			try {
				recipes = fileservice.storeAllRecipes();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return recipes;
	}
}
