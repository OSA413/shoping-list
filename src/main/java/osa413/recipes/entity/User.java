package osa413.recipes.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private Recipe[] favoriteRecipes;

    @ManyToMany
    private Product[] favoriteProduct;

    @ManyToMany
    private Allergen[] allergens;
}