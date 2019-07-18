package com.bytecruncher.backacity.data;

import com.bytecruncher.backacity.model.Recipe;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface RecipeApi {
    @GET("baking.json")
    Single<List<Recipe>> getRecipes();
}
