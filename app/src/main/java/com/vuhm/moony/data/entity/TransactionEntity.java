package com.vuhm.moony.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Entity(tableName = "transaction")
public class TransactionEntity {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "transaction_id")
    private String transactionId;
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
    @TypeConverters(DateConverter.class)
    private Date createdDate;
    @ColumnInfo(name = "updated_date")
    @TypeConverters(DateConverter.class)
    private Date updatedDate;

    public TransactionEntity() {
        this.transactionId = UUID.randomUUID().toString();
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
        this.transactionId = UUID.randomUUID().toString();
        this.title = title;
        this.amount = amount;
        this.description = description;
        this.categoryId = categoryId;
        this.savingId = savingId;
        this.createdDate = Calendar.getInstance().getTime();
        this.updatedDate = Calendar.getInstance().getTime();
    }

    public TransactionEntity(
            String transactionId,
            String title,
            double amount,
            String description,
            String categoryId,
            String savingId,
            Date createdDate,
            Date updatedDate
    ) {
        this.transactionId = transactionId;
        this.title = title;
        this.amount = amount;
        this.description = description;
        this.categoryId = categoryId;
        this.savingId = savingId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSavingId() {
        return savingId;
    }

    public void setSavingId(String savingId) {
        this.savingId = savingId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
