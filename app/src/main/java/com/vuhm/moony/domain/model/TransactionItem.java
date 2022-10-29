package com.vuhm.moony.domain.model;

public class TransactionItem {
    private final Transaction transaction;
    private final Category category;
    private final Saving saving;

    public TransactionItem(
            Transaction transaction,
            Category category,
            Saving saving
    ) {
        this.transaction = transaction;
        this.category = category;
        this.saving = saving;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Category getCategory() {
        return category;
    }

    public Saving getSaving() {
        return saving;
    }
}
