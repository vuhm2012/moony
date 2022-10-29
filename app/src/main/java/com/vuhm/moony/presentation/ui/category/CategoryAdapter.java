package com.vuhm.moony.presentation.ui.category;

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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private final List<String> categories;
    private final OnItemClick<String> listener;

    public CategoryAdapter(List<String> categories, OnItemClick listener) {
        this.categories = categories;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView lbCategoryTitle;
        private final CardView cardCategory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lbCategoryTitle = itemView.findViewById(R.id.lb_category_title);
            cardCategory = itemView.findViewById(R.id.card_category);
        }

        public TextView getLbCategoryTitle() {
            return lbCategoryTitle;
        }

        public CardView getCardCategory() {
            return cardCategory;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = categories.get(position);
        holder.getLbCategoryTitle().setText(item);
        holder.getCardCategory().setOnClickListener(view -> listener.onClick(item));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
