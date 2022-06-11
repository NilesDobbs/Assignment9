package com.coderscampus.Assignment9.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.service.RecipeService;

@RestController
public class RecipeController {
	@Autowired
	private RecipeService recipeService;

	@GetMapping("/all-recipes")
	public List<Recipe> allRecipes() throws IOException {
		return recipeService.getAllRecipes();
	}

	@GetMapping("/vegetarian")
	public List<Recipe> vegetarian() throws IOException {
		return recipeService.getVegetarian();
	}

	@GetMapping("/vegan")
	public List<Recipe> vegan() throws IOException {
		return recipeService.getVegan();
	}

	@GetMapping("/gluten-free")
	public List<Recipe> glutenFree() throws IOException {
		return recipeService.getGlutenFree();
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> VeganAndGlutenFree() throws IOException {
		return recipeService.getVeganAndGlutenFree();
	}
}
