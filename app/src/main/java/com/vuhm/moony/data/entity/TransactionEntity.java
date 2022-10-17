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
    private final UUID id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "amount")
    private double amount;
    @ColumnInfo(name = "category_id")
    private UUID categoryId;
    @ColumnInfo(name = "created_date")
    private final Date createdDate;
    @ColumnInfo(name = "updated_date")
    private Date updatedDate;

    public TransactionEntity() {
        this.id = UUID.randomUUID();
        this.createdDate = Calendar.getInstance().getTime();
        this.updatedDate = Calendar.getInstance().getTime();
    }

    public TransactionEntity(String title, double amount, UUID categoryId) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.amount = amount;
        this.categoryId = categoryId;
        this.createdDate = Calendar.getInstance().getTime();
        this.updatedDate = Calendar.getInstance().getTime();
    }

    public TransactionEntity(UUID id, String title, double amount, UUID categoryId, Date createdDate, Date updatedDate) {
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
}
