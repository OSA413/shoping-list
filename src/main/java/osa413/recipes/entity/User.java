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
    public List<Recipe> favoriteRecipes;

    @ManyToMany
    public List<Product> favoriteProduct;

    @ManyToMany
    public List<Allergen> allergens;
}