package com.bytecruncher.backacity.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bytecruncher.backacity.R;
import com.bytecruncher.backacity.model.Step;
import com.bytecruncher.backacity.viewmodel.RecipeDetailViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StepDetailFragment extends Fragment {
    public static final String STEP_KEY = "STEP_KEY";

    private RecipeDetailViewModel mViewModel;

    @BindView(R.id.tv_step_description)
    TextView mDescriptionTextView;

    public static StepDetailFragment newInstance(Step step) {
        StepDetailFragment fragment = new StepDetailFragment();

        Bundle args = new Bundle();
        args.putParcelable(STEP_KEY, step);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.step_detail_fragment, container, false);
        ButterKnife.bind(this, view);

        if(getArguments() != null) {
            Step step = getArguments().getParcelable(STEP_KEY);
            mDescriptionTextView.setText(step.getDescription());
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
