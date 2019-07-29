package com.bytecruncher.backacity.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bytecruncher.backacity.R;
import com.bytecruncher.backacity.viewmodel.RecipeDetailViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A fragment representing a list of Items.
 * <p/>
 */
public class StepListFragment extends Fragment {
    @BindView(R.id.tv_servings)
    TextView servingsTextView;
    @BindView(R.id.tv_ingredients)
    TextView ingredientsTextView;
    @BindView(R.id.tv_steps)
    RecyclerView stepListRecyclerView;

    private StepListAdapter mAdapter;
    private RecipeDetailViewModel mViewModel;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public StepListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_steplist, container, false);
        ButterKnife.bind(this, view);
        mAdapter = new StepListAdapter();
        stepListRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(RecipeDetailViewModel.class);

        mViewModel.getRecipe().observe(getViewLifecycleOwner(), recipe -> {
            servingsTextView.setText(getString(R.string.servings, recipe.getServings()));
            ingredientsTextView.setText(recipe.getIngredientString());
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
