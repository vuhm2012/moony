package com.vuhm.moony.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Entity(tableName = "transaction")
public class TransactionEntity {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private final String id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "amount")
    private double amount;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "category_id")
    private String categoryId;
    @ColumnInfo(name = "saving_id")
    private String savingId;
    @ColumnInfo(name = "created_date")
    private final Date createdDate;
    @ColumnInfo(name = "updated_date")
    private Date updatedDate;

    public TransactionEntity() {
        this.id = UUID.randomUUID().toString();
        this.savingId = "-1";
        this.createdDate = Calendar.getInstance().getTime();
        this.updatedDate = Calendar.getInstance().getTime();
    }

    public TransactionEntity(
            String title,
            double amount,
            String description,
            String categoryId,
            String savingId
    ) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.amount = amount;
        this.description = description;
        this.categoryId = categoryId;
        this.savingId = savingId;
        this.createdDate = Calendar.getInstance().getTime();
        this.updatedDate = Calendar.getInstance().getTime();
    }

    public TransactionEntity(
            String id,
            String title,
            double amount,
            String description,
            String categoryId,
            String savingId,
            Date createdDate,
            Date updatedDate
    ) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.description = description;
        this.categoryId = categoryId;
        this.savingId = savingId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getSavingId() {
        return savingId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }
}
