package osa413.recipes.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import osa413.recipes.entity.Allergen;
import osa413.recipes.entity.Product;

@Data
public class ProductDTO {

    private Long id;
    @NotBlank
    private String name;
    @PositiveOrZero
    private Double price;


    public Product toEntity() {
        var e = new Product();
        e.id = id;
        e.name = name;
        e.price = price;
        return e;
    }
}