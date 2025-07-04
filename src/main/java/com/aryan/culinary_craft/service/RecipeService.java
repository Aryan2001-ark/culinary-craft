package com.aryan.culinary_craft.service;

import com.aryan.culinary_craft.model.Recipe;
import com.aryan.culinary_craft.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> createRecipes(List<Recipe> recipes) {
        return recipeRepository.saveAll(recipes);
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(String id) {
        return recipeRepository.findById(id);
    }

    public void deleteRecipe(String id) {
        recipeRepository.deleteById(id);
    }

    public List<Recipe> getRecipesByName(String name) {
        return recipeRepository.findByNameContainingIgnoreCase(name);
    }
}
