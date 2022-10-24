package com.vuhm.moony.domain.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    private final String id;
    private String title;
    private double amount;
    private String description;
    private String categoryId;
    private String savingId;
    private final Date createdDate;
    private final Date updatedDate;

    public Transaction() {
        this.id = UUID.randomUUID().toString();
        this.savingId = "-1";
        this.createdDate = Calendar.getInstance().getTime();
        this.updatedDate = Calendar.getInstance().getTime();
    }

    public Transaction(
            String title,
            double amount,
            String categoryId,
            String savingId
    ) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.amount = amount;
        this.description = "";
        this.categoryId = categoryId;
        this.savingId = savingId;
        this.createdDate = Calendar.getInstance().getTime();
        this.updatedDate = Calendar.getInstance().getTime();
    }

    public Transaction(
            String title,
            Double amount,
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

    public Transaction(
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

    public void updateTransaction(
            String title,
            double amount,
            String categoryId,
            String savingId
    ) {
        this.title = title;
        this.amount = amount;
        this.categoryId = categoryId;
        this.savingId = savingId;
    }
}
