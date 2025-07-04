package com.aryan.culinary_craft.repository;

import com.aryan.culinary_craft.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, String> {
    // Custom queries can go here later
    List<Recipe> findByNameContainingIgnoreCase(String name);
}
