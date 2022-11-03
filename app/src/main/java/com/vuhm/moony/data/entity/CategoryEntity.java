package com.vuhm.moony.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Entity(tableName = "category")
@TypeConverters(DateConverter.class)
public class CategoryEntity {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "category_id")
    private String categoryId;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "icon_res_id")
    private int iconResId;
    @ColumnInfo(name = "is_income")
    private boolean isIncome;
    @ColumnInfo(name = "created_date")
    @TypeConverters(DateConverter.class)
    private Date createdDate;
    @ColumnInfo(name = "updated_date")
    @TypeConverters(DateConverter.class)
    private Date updatedDate;

    public CategoryEntity() {
        this.categoryId = UUID.randomUUID().toString();
        this.createdDate = Calendar.getInstance().getTime();
        this.updatedDate = Calendar.getInstance().getTime();
    }

    public CategoryEntity(
            String title,
            int iconResId,
            boolean isIncome
    ) {
        this.categoryId = UUID.randomUUID().toString();
        this.title = title;
        this.iconResId = iconResId;
        this.isIncome = isIncome;
        this.createdDate = Calendar.getInstance().getTime();
        this.updatedDate = Calendar.getInstance().getTime();
    }

    public CategoryEntity(
            String catergoryId,
            String title,
            int iconResId,
            boolean isIncome,
            Date createdDate,
            Date updatedDate
    ) {
        this.categoryId = catergoryId;
        this.title = title;
        this.iconResId = iconResId;
        this.isIncome = isIncome;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    public boolean isIncome() {
        return isIncome;
    }

    public void setIncome(boolean income) {
        isIncome = income;
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
