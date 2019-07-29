package com.bytecruncher.backacity.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.bytecruncher.backacity.R;
import com.bytecruncher.backacity.model.Recipe;
import com.bytecruncher.backacity.viewmodel.RecipeDetailViewModel;

public class RecipeDetailActivity extends AppCompatActivity {
    public static final String RECIPE_KEY = "RECIPE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        Recipe recipe = getIntent().getParcelableExtra(RECIPE_KEY);
        setTitle(recipe.getName());

        //Setting the recipe for the shared viewmodel so the fragments can access it
        ViewModelProviders.of(this).get(RecipeDetailViewModel.class).setRecipe(recipe);
    }
}
