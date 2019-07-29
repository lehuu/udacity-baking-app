package com.bytecruncher.backacity.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bytecruncher.backacity.model.Recipe;

public class RecipeDetailViewModel extends ViewModel {
    private MutableLiveData<Recipe> mRecipe = new MutableLiveData<>();

    public RecipeDetailViewModel() {
    }

    public MutableLiveData<Recipe> getRecipe() {
        return mRecipe;
    }

    public void setRecipe(Recipe recipe) {
        this.mRecipe.setValue(recipe);
    }
}
