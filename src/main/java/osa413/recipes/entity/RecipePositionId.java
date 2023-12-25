package osa413.recipes.entity;

import java.io.Serializable;

public class RecipePositionId implements Serializable {
    private String amount;

    private String productId;

    public RecipePositionId(String amount, String productId) {
        this.amount = amount;
        this.productId = productId;
    }
}
