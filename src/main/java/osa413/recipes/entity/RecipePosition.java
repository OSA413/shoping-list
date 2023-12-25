package osa413.recipes.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@IdClass(RecipePositionId.class)
public class RecipePosition {

    @Id
    public Double amount;

    @Id
    public Long productId;
}