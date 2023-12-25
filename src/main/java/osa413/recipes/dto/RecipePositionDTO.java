package osa413.recipes.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import osa413.recipes.entity.Allergen;
import osa413.recipes.entity.Product;
import osa413.recipes.entity.Recipe;
import osa413.recipes.entity.RecipePosition;

@Data
public class RecipePositionDTO {

    @NotBlank
    private Long productId;
    @NotBlank
    private Double amount;


    public RecipePosition toEntity() {
        var e = new RecipePosition();
        e.amount = amount;
        e.productId = productId;
        return e;
    }
}