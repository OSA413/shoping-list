package osa413.recipes.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
    public List<Product> products;
}