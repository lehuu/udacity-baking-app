package com.bytecruncher.backacity.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bytecruncher.backacity.R;
import com.bytecruncher.backacity.model.Recipe;
import com.bytecruncher.backacity.viewmodel.MainViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_recipes)
    RecyclerView recipeRecyclerView;
    RecipeAdapter mAdapter;

    private MainViewModel mMainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mAdapter = new RecipeAdapter(Glide.with(this));
        recipeRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(position -> {
            //Open the detail of the clicked Recipe
            if(mMainViewModel.getRecipes().getValue() != null) {
                Recipe recipe = mMainViewModel.getRecipes().getValue().get(position);
                Log.d("Clicked", recipe.toString());
            }
        });

        mMainViewModel.getRecipes().observe(this, recipes -> {
            mAdapter.setRecipes(recipes);
        });


    }
}
