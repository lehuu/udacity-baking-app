package com.bytecruncher.backacity.model;

import androidx.annotation.NonNull;

public class Ingredient {
    private float quantity;
    private String measure;
    private String ingredient;

    public float getQuantity() {
        return quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    @NonNull
    @Override
    public String toString() {
        return quantity + " " + measure + " of " + ingredient;
    }
}
