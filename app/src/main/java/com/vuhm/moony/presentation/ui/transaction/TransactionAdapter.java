package com.vuhm.moony.presentation.ui.transaction;

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

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private List<String> localDataSet;
    private OnItemClick<String> listener;

    public TransactionAdapter(List<String> localDataSet, OnItemClick listener) {
        this.localDataSet = localDataSet;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView lbTransactionTitle;
        private final CardView cardTransaction;

        public ViewHolder(View view) {
            super(view);
            cardTransaction = view.findViewById(R.id.card_transaction);
            lbTransactionTitle = view.findViewById(R.id.lb_transaction_title);
        }

        public TextView getLbTransactionTitle() {
            return lbTransactionTitle;
        }

        public CardView getCardTransaction() {
            return cardTransaction;
        }
    }

    public void setData(List<String> list) {
        localDataSet = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = localDataSet.get(position);
        holder.getLbTransactionTitle().setText(item);
        holder.getCardTransaction().setOnClickListener(view -> listener.onClick(item));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
