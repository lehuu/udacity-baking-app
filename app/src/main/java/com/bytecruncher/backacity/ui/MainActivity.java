package com.bytecruncher.backacity.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

        mAdapter = new RecipeAdapter();
        recipeRecyclerView.setAdapter(mAdapter);

        mMainViewModel.getRecipes().observe(this, recipes -> {
            mAdapter.setRecipes(recipes);
        });
    }
}
