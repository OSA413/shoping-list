package osa413.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import osa413.recipes.entity.Allergen;

public interface AllergenRepository
        extends JpaRepository<Allergen, Long> {

}