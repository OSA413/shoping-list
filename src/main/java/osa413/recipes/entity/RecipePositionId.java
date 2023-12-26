package osa413.recipes.entity;

import java.io.Serializable;

public class RecipePositionId implements Serializable {
    private String amount;

    private String productId;

    public RecipePositionId(String amount, String productId) {
        this.amount = amount;
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.productId.hashCode();
        hash = 53 * hash + this.amount.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        return this.productId == ((RecipePositionId) obj).productId
                && this.amount == ((RecipePositionId) obj).amount;
    }
}
