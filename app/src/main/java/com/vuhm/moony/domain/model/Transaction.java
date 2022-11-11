package com.vuhm.moony.domain.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    private final String transactionId;
    private String transactionTitle;
    private double transactionAmount;
    private String transactionDescription;
    private String categoryId;
    private String savingId;
    private final Date createdTransactionDate;
    private Date updatedTransactionDate;

    public Transaction() {
        this.transactionId = UUID.randomUUID().toString();
        this.savingId = "-1";
        this.createdTransactionDate = Calendar.getInstance().getTime();
        this.updatedTransactionDate = Calendar.getInstance().getTime();
    }

    public Transaction(
            String transactionTitle,
            double transactionAmount,
            String transactionDescription,
            String categoryId
    ) {
        this.transactionId = UUID.randomUUID().toString();
        this.transactionTitle = transactionTitle;
        this.transactionAmount = transactionAmount;
        this.transactionDescription = transactionDescription;
        this.categoryId = categoryId;
        this.createdTransactionDate = Calendar.getInstance().getTime();
        this.updatedTransactionDate = Calendar.getInstance().getTime();
    }

    public Transaction(
            String transactionTitle,
            Double transactionAmount,
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
        this.createdTransactionDate = Calendar.getInstance().getTime();
        this.updatedTransactionDate = Calendar.getInstance().getTime();
    }

    public Transaction(
            String transactionId,
            String transactionTitle,
            double transactionAmount,
            String transactionDescription,
            String categoryId,
            String savingId,
            Date createdDate,
            Date updatedTransactionDate
    ) {
        this.transactionId = transactionId;
        this.transactionTitle = transactionTitle;
        this.transactionAmount = transactionAmount;
        this.transactionDescription = transactionDescription;
        this.categoryId = categoryId;
        this.savingId = savingId;
        this.createdTransactionDate = createdDate;
        this.updatedTransactionDate = updatedTransactionDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getTransactionTitle() {
        return transactionTitle;
    }

    public void setTransactionTitle(String transactionTitle) {
        this.transactionTitle = transactionTitle;
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

    public Date getCreatedTransactionDate() {
        return createdTransactionDate;
    }

    public Date getUpdatedTransactionDate() {
        return updatedTransactionDate;
    }

    public void setUpdatedTransactionDate(Date updatedTransactionDate) {
        this.updatedTransactionDate = updatedTransactionDate;
    }

    public void updateTransaction(
            String transactionTitle,
            String transactionDescription,
            double transactionAmount,
            String categoryId,
            String savingId
    ) {
        this.transactionTitle = transactionTitle;
        this.transactionDescription = transactionDescription;
        this.transactionAmount = transactionAmount;
        this.categoryId = categoryId;
        this.savingId = savingId;
        this.updatedTransactionDate = Calendar.getInstance().getTime();
    }
}
