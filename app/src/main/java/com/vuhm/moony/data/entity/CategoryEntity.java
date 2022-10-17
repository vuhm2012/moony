package com.vuhm.moony.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Entity(tableName = "category")
public class CategoryEntity {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private final UUID id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "icon_res_id")
    private int iconResId;
    @ColumnInfo(name = "is_income")
    private boolean isIncome;
    @ColumnInfo(name = "created_date")
    private final Date createdDate;
    @ColumnInfo(name = "updated_date")
    private Date updatedDate;

    public CategoryEntity() {
        this.id = UUID.randomUUID();
        this.createdDate = Calendar.getInstance().getTime();
        this.updatedDate = Calendar.getInstance().getTime();
    }

    public CategoryEntity(String title, int iconResId, boolean isIncome) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.iconResId = iconResId;
        this.isIncome = isIncome;
        this.createdDate = Calendar.getInstance().getTime();
        this.updatedDate = Calendar.getInstance().getTime();
    }

    public CategoryEntity(UUID id, String title, int iconResId, boolean isIncome, Date createdDate, Date updatedDate) {
        this.id = id;
        this.title = title;
        this.iconResId = iconResId;
        this.isIncome = isIncome;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getIconResId() {
        return iconResId;
    }

    public boolean isIncome() {
        return isIncome;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }
}
