package com.vuhm.moony.presentation.ui.saving;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.vuhm.moony.R;
import com.vuhm.moony.core.utils.OnItemClick;
import com.vuhm.moony.domain.model.Saving;

import java.util.List;

public class SavingAdapter extends RecyclerView.Adapter<SavingAdapter.ViewHolder> {

    private final List<Saving> savings;
    private final OnItemClick<Saving> listener;
    private final double savingAmount;

    public SavingAdapter(List<Saving> savings, OnItemClick listener, double savingAmount) {
        this.savings = savings;
        this.listener = listener;
        this.savingAmount = savingAmount;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView lbSavingTitle, lbSavingDescription, lbSavingGoal, lbSavingAmount, lbCreatedAt, lbUpdatedAt;
        private final LinearProgressIndicator prgSaving;
        private final CardView cardSaving;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lbSavingTitle = itemView.findViewById(R.id.lb_saving_title);
            lbSavingDescription = itemView.findViewById(R.id.lb_saving_description);
            lbSavingGoal = itemView.findViewById(R.id.lb_saving_goal);
            lbSavingAmount = itemView.findViewById(R.id.lb_saving_amount);
            lbCreatedAt = itemView.findViewById(R.id.lb_created_at);
            lbUpdatedAt = itemView.findViewById(R.id.lb_updated_at);
            prgSaving = itemView.findViewById(R.id.prg_saving);
            cardSaving = itemView.findViewById(R.id.card_saving);
        }

        public TextView getLbSavingTitle() {
            return lbSavingTitle;
        }

        public CardView getCardSaving() {
            return cardSaving;
        }

        public TextView getLbSavingDescription() {
            return lbSavingDescription;
        }

        public TextView getLbSavingGoal() {
            return lbSavingGoal;
        }

        public TextView getLbCreatedAt() {
            return lbCreatedAt;
        }

        public LinearProgressIndicator getPrgSaving() {
            return prgSaving;
        }

        public TextView getLbSavingAmount() {
            return lbSavingAmount;
        }

        public TextView getLbUpdatedAt() {
            return lbUpdatedAt;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_saving, parent, false);
        return new SavingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Saving item = savings.get(position);
        holder.getLbSavingTitle().setText(item.getTitle());
        holder.getCardSaving().setOnClickListener(view -> listener.onClick(item));
        holder.getLbSavingDescription().setText(item.getDescription());
        holder.getLbSavingGoal().setText(String.valueOf(item.getGoal()));
        holder.getLbCreatedAt().setText(item.getCreatedAt().toString());
        holder.getLbUpdatedAt().setText(item.getUpdatedAt().toString());
        holder.getLbSavingAmount().setText(String.valueOf(savingAmount));
        holder.getPrgSaving().setProgress((int) savingAmount);
    }

    @Override
    public int getItemCount() {
        return savings.size();
    }
}
