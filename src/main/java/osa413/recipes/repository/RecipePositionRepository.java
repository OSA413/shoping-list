package osa413.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import osa413.recipes.entity.RecipePosition;

public interface RecipePositionRepository
        extends JpaRepository<RecipePosition, Long> {

}