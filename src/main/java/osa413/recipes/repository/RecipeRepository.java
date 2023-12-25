package osa413.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import osa413.recipes.entity.Recipe;

public interface RecipeRepository
        extends JpaRepository<Recipe, Long> {

}