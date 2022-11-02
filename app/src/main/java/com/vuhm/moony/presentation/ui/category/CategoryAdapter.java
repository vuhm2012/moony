package com.vuhm.moony.presentation.ui.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.vuhm.moony.R;
import com.vuhm.moony.core.utils.OnItemClick;
import com.vuhm.moony.domain.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private final Context context;
    private final List<Category> categories;
    private final OnItemClick<Category> listener;
//    private final int countTransaction;

    public CategoryAdapter(
            Context context,
            List<Category> categories,
            OnItemClick listener
//            int countTransaction
    ) {
        this.context = context;
        this.categories = categories;
        this.listener = listener;
//        this.countTransaction = countTransaction;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView lbCategoryTitle, lbNumOfTransaction;
        private final CardView cardCategory;
        private final ImageView imgIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lbCategoryTitle = itemView.findViewById(R.id.lb_category_title);
            cardCategory = itemView.findViewById(R.id.card_category);
            imgIcon = itemView.findViewById(R.id.img_category);
            lbNumOfTransaction = itemView.findViewById(R.id.lb_num_of_transactions);
        }

        public TextView getLbCategoryTitle() {
            return lbCategoryTitle;
        }

        public CardView getCardCategory() {
            return cardCategory;
        }

        public ImageView getImageView() {
            return imgIcon;
        }

        public TextView getLbNumOfTransaction() {
            return lbNumOfTransaction;
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
        Category item = categories.get(position);
        if (categories.get(position).isIncome()) {
            holder.getLbCategoryTitle().setTextColor(context.getResources().getColor(R.color.color_green));
            holder.getImageView().setColorFilter(context.getResources().getColor(R.color.color_green));
        } else {
            holder.getLbCategoryTitle().setTextColor(context.getResources().getColor(R.color.color_red));
            holder.getImageView().setColorFilter(context.getResources().getColor(R.color.color_red));
        }
        holder.getLbCategoryTitle().setText(item.getTitle());
        holder.getCardCategory().setOnClickListener(view -> listener.onClick(item));
        holder.getImageView().setImageResource(item.getIconResId());
//        holder.getLbNumOfTransaction().setText(countTransaction);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
