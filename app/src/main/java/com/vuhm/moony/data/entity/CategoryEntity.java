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
    @ColumnInfo(name = "category_title")
    private String categoryTitle;
    @ColumnInfo(name = "category_icon_res_id")
    private int categoryIconResId;
    @ColumnInfo(name = "is_income")
    private boolean isIncome;
    @ColumnInfo(name = "category_created_date")
    @TypeConverters(DateConverter.class)
    private Date categoryCreatedDate;
    @ColumnInfo(name = "category_updated_date")
    @TypeConverters(DateConverter.class)
    private Date categoryUpdatedDate;

    public CategoryEntity() {
        this.categoryId = UUID.randomUUID().toString();
        this.categoryCreatedDate = Calendar.getInstance().getTime();
        this.categoryUpdatedDate = Calendar.getInstance().getTime();
    }

    public CategoryEntity(
            String categoryTitle,
            int categoryIconResId,
            boolean isIncome
    ) {
        this.categoryId = UUID.randomUUID().toString();
        this.categoryTitle = categoryTitle;
        this.categoryIconResId = categoryIconResId;
        this.isIncome = isIncome;
        this.categoryCreatedDate = Calendar.getInstance().getTime();
        this.categoryUpdatedDate = Calendar.getInstance().getTime();
    }

    public CategoryEntity(
            String catergoryId,
            String categoryTitle,
            int categoryIconResId,
            boolean isIncome,
            Date categoryCreatedDate,
            Date categoryUpdatedDate
    ) {
        this.categoryId = catergoryId;
        this.categoryTitle = categoryTitle;
        this.categoryIconResId = categoryIconResId;
        this.isIncome = isIncome;
        this.categoryCreatedDate = categoryCreatedDate;
        this.categoryUpdatedDate = categoryUpdatedDate;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public int getCategoryIconResId() {
        return categoryIconResId;
    }

    public void setCategoryIconResId(int categoryIconResId) {
        this.categoryIconResId = categoryIconResId;
    }

    public boolean isIncome() {
        return isIncome;
    }

    public void setIncome(boolean income) {
        isIncome = income;
    }

    public Date getCategoryCreatedDate() {
        return categoryCreatedDate;
    }

    public void setCategoryCreatedDate(Date categoryCreatedDate) {
        this.categoryCreatedDate = categoryCreatedDate;
    }

    public Date getCategoryUpdatedDate() {
        return categoryUpdatedDate;
    }

    public void setCategoryUpdatedDate(Date categoryUpdatedDate) {
        this.categoryUpdatedDate = categoryUpdatedDate;
    }
}
