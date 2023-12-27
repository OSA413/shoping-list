package osa413.recipes.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import osa413.recipes.entity.Allergen;
import osa413.recipes.entity.Product;
import osa413.recipes.entity.Recipe;
import osa413.recipes.entity.RecipePosition;

@Data
public class RecipePositionDTO {

    @Positive
    public Long productId;
    @Positive
    public Double amount;

}