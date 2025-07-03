package com.aryan.culinary_craft.repository;

import com.aryan.culinary_craft.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, String> {
    // Custom queries can go here later
}
