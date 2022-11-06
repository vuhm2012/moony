package com.vuhm.moony.presentation.ui.transaction;

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
import com.vuhm.moony.domain.model.TransactionItem;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private Context context;
    private List<TransactionItem> transactionItems;
    private OnItemClick<TransactionItem> listener;

    public TransactionAdapter(Context context, List<TransactionItem> transactionItems, OnItemClick listener) {
        this.context = context;
        this.transactionItems = transactionItems;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView lbTransactionTitle, lbTransactionDescription, lbTransactionAmount, lbCreate, lbUpdate;
        private final CardView cardTransaction;
        private final ImageView imgIcon, imgType;

        public ViewHolder(View view) {
            super(view);
            cardTransaction = view.findViewById(R.id.card_transaction);
            lbTransactionAmount = view.findViewById(R.id.lb_transaction_amount);
            lbTransactionDescription = view.findViewById(R.id.lb_transaction_description);
            lbTransactionTitle = view.findViewById(R.id.lb_transaction_title);
            lbCreate = view.findViewById(R.id.lb_created_at);
            lbUpdate = view.findViewById(R.id.lb_updated_at);
            imgIcon = view.findViewById(R.id.img_category);
            imgType = view.findViewById(R.id.img_transaction_type);
        }

        public TextView getLbTransactionTitle() {
            return lbTransactionTitle;
        }

        public TextView getLbTransactionDescription() {
            return lbTransactionDescription;
        }

        public TextView getLbTransactionAmount() {
            return lbTransactionAmount;
        }

        public CardView getCardTransaction() {
            return cardTransaction;
        }

        public TextView getLbCreate() {
            return lbCreate;
        }

        public TextView getLbUpdate() {
            return lbUpdate;
        }

        public ImageView getImgIcon() {
            return imgIcon;
        }

        public ImageView getImgType() {
            return imgType;
        }

    }

    public void setData(List<TransactionItem> list) {
        transactionItems = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TransactionItem item = transactionItems.get(position);
        holder.getLbTransactionTitle().setText(item.getTransaction().getTransactionTitle());
        holder.getCardTransaction().setOnClickListener(view -> listener.onClick(item));
        holder.getLbTransactionAmount().setText(String.valueOf(item.getTransaction().getTransactionAmount()));
        holder.lbTransactionDescription.setText(item.getTransaction().getTransactionDescription());
        holder.getImgIcon().setImageResource(item.getCategory().getCategoryResId());
        holder.getLbCreate().setText(item.getTransaction().getCreatedTransactionDate().toString());
        holder.getLbUpdate().setText(item.getTransaction().getUpdatedTransactionDate().toString());
        if (item.getCategory().isIncome()) {
            holder.getImgIcon().setColorFilter(context.getResources().getColor(R.color.color_green));
            holder.getImgType().setImageResource(R.drawable.ic_income);
            holder.getImgType().setColorFilter(context.getResources().getColor(R.color.color_green));
            holder.getLbTransactionAmount().setTextColor(context.getResources().getColor(R.color.color_green));
        } else {
            holder.getImgIcon().setColorFilter(context.getResources().getColor(R.color.color_red));
            holder.getImgType().setImageResource(R.drawable.ic_expense);
            holder.getImgType().setColorFilter(context.getResources().getColor(R.color.color_red));
            holder.getLbTransactionAmount().setTextColor(context.getResources().getColor(R.color.color_red));
        }

    }

    @Override
    public int getItemCount() {
        return transactionItems.size();
    }
}
