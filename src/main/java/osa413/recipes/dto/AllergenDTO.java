package osa413.recipes.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import osa413.recipes.entity.Allergen;

@Data
public class AllergenDTO {

    private Long id;
    @NotBlank
    private String name;


    public Allergen toEntity() {
        var e = new Allergen();
        e.id = id;
        e.name = name;
        return e;
    }
}