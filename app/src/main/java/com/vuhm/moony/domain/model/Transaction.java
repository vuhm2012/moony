package com.vuhm.moony.domain.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    private final UUID id;
    private String title;
    private double amount;
    private UUID categoryId;
    private final Date createdDate;
    private Date updatedDate;

    public Transaction() {
        this.id = UUID.randomUUID();
        this.createdDate = Calendar.getInstance().getTime();
        this.updatedDate = Calendar.getInstance().getTime();
    }

    public Transaction(String title, Double amount, UUID categoryId) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.amount = amount;
        this.categoryId = categoryId;
        this.createdDate = Calendar.getInstance().getTime();
        this.updatedDate = Calendar.getInstance().getTime();
    }

    public Transaction(UUID id, String title, double amount, UUID categoryId, Date createdDate, Date updatedDate) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.categoryId = categoryId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void updateTransaction(String title, double amount, UUID categoryId) {
        this.title = title;
        this.amount = amount;
        this.categoryId = categoryId;
        this.updatedDate = Calendar.getInstance().getTime();
    }
}
