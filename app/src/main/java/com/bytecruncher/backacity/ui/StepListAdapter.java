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
        @BindView(R.id.item_number)
        TextView mIdView;
        @BindView(R.id.content)
        TextView mContentView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bindView(Step step) {
            //mIdView.setText(mValues.get(position).id);
            //mContentView.setText(mValues.get(position).content);
        }

    }
}
