package osa413.recipes.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;

    public String difficulty;

    public Integer preparationTimeMins;

    @ManyToMany
    public Product[] products;
}