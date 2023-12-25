package osa413.recipes.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import osa413.recipes.entity.Allergen;
import osa413.recipes.entity.Product;
import osa413.recipes.entity.Recipe;

@Data
public class RecipeDTO {

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private Double price;
    @NotBlank
    private String difficulty;
    @NotBlank
    private Integer preparationTimeMins;


    public Recipe toEntity() {
        var e = new Recipe();
        e.id = id;
        e.name = name;
        e.difficulty = difficulty;
        e.preparationTimeMins = preparationTimeMins;
        return e;
    }
}