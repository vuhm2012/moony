package com.vuhm.moony.presentation.ui.saving;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.vuhm.moony.R;
import com.vuhm.moony.core.utils.OnItemClick;

import java.util.List;

public class SavingAdapter extends RecyclerView.Adapter<SavingAdapter.ViewHolder> {

    private final List<String> savings;
    private final OnItemClick<String> listener;

    public SavingAdapter(List<String> savings, OnItemClick listener) {
        this.savings = savings;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView lbSavingTitle;
        private final CardView cardSaving;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lbSavingTitle = itemView.findViewById(R.id.lb_saving_title);
            cardSaving = itemView.findViewById(R.id.card_saving);
        }

        public TextView getLbSavingTitle() {
            return lbSavingTitle;
        }

        public CardView getCardSaving() {
            return cardSaving;
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
        String item = savings.get(position);
        holder.getLbSavingTitle().setText(item);
        holder.getCardSaving().setOnClickListener(view -> listener.onClick(item));
    }

    @Override
    public int getItemCount() {
        return savings.size();
    }
}
