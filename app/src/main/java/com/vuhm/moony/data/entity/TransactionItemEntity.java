package com.vuhm.moony.data.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

public class TransactionItemEntity {
    @Embedded
    private final TransactionEntity transaction;
    @Relation(
            parentColumn = "category_id",
            entityColumn = "id"
    )
    private final CategoryEntity category;
    @Relation(
            parentColumn = "saving_id",
            entityColumn = "id"
    )
    private final SavingEntity saving;

    public TransactionItemEntity(
            TransactionEntity transaction,
            CategoryEntity category,
            SavingEntity saving
    ) {
        this.transaction = transaction;
        this.category = category;
        this.saving = saving;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public SavingEntity getSaving() {
        return saving;
    }
}
