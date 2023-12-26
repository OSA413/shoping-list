package osa413.recipes.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private List<Recipe> favoriteRecipes;

    @ManyToMany
    private List<Product> favoriteProduct;

    @ManyToMany
    private List<Allergen> allergens;
}