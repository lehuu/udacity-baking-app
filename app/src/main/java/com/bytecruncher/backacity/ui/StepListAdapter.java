package com.bytecruncher.backacity.ui;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bytecruncher.backacity.R;
import com.bytecruncher.backacity.model.Step;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StepListAdapter extends RecyclerView.Adapter<StepListAdapter.ViewHolder> {

    private List<Step> mSteps;

    public void setSteps(List<Step> steps) {
        mSteps = steps;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_steplist_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bindView(mSteps.get(position));
    }

    @Override
    public int getItemCount() {
        return mSteps == null ? 0 : mSteps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_step_id)
        TextView mIdTextView;
        @BindView(R.id.tv_step_description)
        TextView mDescriptionView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bindView(Step step) {
            mIdTextView.setText(step.getId()+".");
            mDescriptionView.setText(step.getShortDescription());
        }

    }
}
