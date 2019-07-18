package com.bytecruncher.backacity.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.bytecruncher.backacity.data.RecipeRepository;
import com.bytecruncher.backacity.model.Recipe;

import java.util.List;

import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {
    private RecipeRepository mRepository;
    private List<Recipe> mRecipes;

    public MainViewModel() {
        mRepository = new RecipeRepository();
        mRepository.getRecipes()
                .subscribeOn(Schedulers.io())
                .doOnSuccess(recipes -> {
                    mRecipes = recipes;
                    for (Recipe recipe : mRecipes) {
                        Log.d("RECIPES", recipe.toString());
                    }
                }).subscribe();
    }
}
