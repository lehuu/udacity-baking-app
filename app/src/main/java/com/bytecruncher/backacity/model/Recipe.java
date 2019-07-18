package com.bytecruncher.backacity.model;

import androidx.annotation.NonNull;

public class Recipe {
    private int id;
    private String name;
    private int servings;
    private String image;

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

    @NonNull
    @Override
    public String toString() {
        return id + ", " + name;
    }
}
