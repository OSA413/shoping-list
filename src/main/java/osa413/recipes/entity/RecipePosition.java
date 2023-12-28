package osa413.recipes.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class RecipePosition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public Double amount;

    @ManyToOne
    public Product product;

    public RecipePosition(Double amount, Product product) {
        this.amount = amount;
        this.product = product;
    }

    public RecipePosition() {
    }
}