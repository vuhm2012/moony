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
    @ColumnInfo(name = "transaction_title")
    private String transactionTitle;
    @ColumnInfo(name = "transaction_amount")
    private double transactionAmount;
    @ColumnInfo(name = "transaction_description")
    private String transactionDescription;
    @ColumnInfo(name = "category_id")
    private String categoryId;
    @ColumnInfo(name = "saving_id")
    private String savingId;
    @ColumnInfo(name = "transaction_created_date")
    @TypeConverters(DateConverter.class)
    private Date transactionCreatedDate;
    @ColumnInfo(name = "transaction_updated_date")
    @TypeConverters(DateConverter.class)
    private Date transactionUpdatedDate;

    public TransactionEntity() {
        this.transactionId = UUID.randomUUID().toString();
        this.savingId = "-1";
        this.transactionCreatedDate = Calendar.getInstance().getTime();
        this.transactionUpdatedDate = Calendar.getInstance().getTime();
    }

    public TransactionEntity(
            String transactionTitle,
            double transactionAmount,
            String transactionDescription,
            String categoryId,
            String savingId
    ) {
        this.transactionId = UUID.randomUUID().toString();
        this.transactionTitle = transactionTitle;
        this.transactionAmount = transactionAmount;
        this.transactionDescription = transactionDescription;
        this.categoryId = categoryId;
        this.savingId = savingId;
        this.transactionCreatedDate = Calendar.getInstance().getTime();
        this.transactionUpdatedDate = Calendar.getInstance().getTime();
    }

    public TransactionEntity(
            String transactionId,
            String transactionTitle,
            double transactionAmount,
            String transactionDescription,
            String categoryId,
            String savingId,
            Date transactionCreatedDate,
            Date transactionUpdatedDate
    ) {
        this.transactionId = transactionId;
        this.transactionTitle = transactionTitle;
        this.transactionAmount = transactionAmount;
        this.transactionDescription = transactionDescription;
        this.categoryId = categoryId;
        this.savingId = savingId;
        this.transactionCreatedDate = transactionCreatedDate;
        this.transactionUpdatedDate = transactionUpdatedDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionTitle() {
        return transactionTitle;
    }

    public void setTransactionTitle(String title) {
        this.transactionTitle = title;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
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

    public Date getTransactionCreatedDate() {
        return transactionCreatedDate;
    }

    public void setTransactionCreatedDate(Date transactionCreatedDate) {
        this.transactionCreatedDate = transactionCreatedDate;
    }

    public Date getTransactionUpdatedDate() {
        return transactionUpdatedDate;
    }

    public void setTransactionUpdatedDate(Date transactionUpdatedDate) {
        this.transactionUpdatedDate = transactionUpdatedDate;
    }
}
