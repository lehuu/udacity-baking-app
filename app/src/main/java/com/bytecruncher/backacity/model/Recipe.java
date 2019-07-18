package com.bytecruncher.backacity.model;

import androidx.annotation.NonNull;

import java.util.List;

public class Recipe {
    private int id;
    private String name;
    private int servings;
    private String image;
    private List<Ingredient> ingredients;
    private List<Step> steps;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getServings() {
        return servings;
    }

    public String getImage() {
        return image;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    @NonNull
    @Override
    public String toString() {
        return id + ": " + name + "\n" + ingredients.toString() + "\n" + steps.toString();
    }
}
