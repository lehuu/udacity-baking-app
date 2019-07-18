package com.bytecruncher.backacity.data;

import com.bytecruncher.backacity.model.Recipe;

import java.util.List;

import io.reactivex.Single;

public class RecipeRepository {
    private RecipeApi mRecipeApi;

    public RecipeRepository(){
        mRecipeApi = RecipeService.getRetrofitInstance().create(RecipeApi.class);
    }

    public Single<List<Recipe>> getRecipes(){
        return mRecipeApi.getRecipes();
    }
}
