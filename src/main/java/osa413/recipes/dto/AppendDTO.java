package osa413.recipes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import osa413.recipes.entity.Allergen;

@Data
public class AppendDTO {

    @Positive
    public Long id;
}