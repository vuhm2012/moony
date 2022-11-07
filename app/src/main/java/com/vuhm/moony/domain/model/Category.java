package com.vuhm.moony.domain.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Category {
    private final String categoryId;
    private String categoryTitle;
    private int categoryResId;
    private boolean isIncome;
    private final Date categoryCreatedDate;
    private Date categoryUpdatedDate;

    public Category() {
        this.categoryId = UUID.randomUUID().toString();
        this.categoryCreatedDate = Calendar.getInstance().getTime();
        this.categoryUpdatedDate = Calendar.getInstance().getTime();
    }

    public Category(
            String categoryTitle,
            int categoryResId,
            boolean isIncome
    ) {
        this.categoryId = UUID.randomUUID().toString();
        this.categoryTitle = categoryTitle;
        this.categoryResId = categoryResId;
        this.isIncome = isIncome;
        this.categoryCreatedDate = Calendar.getInstance().getTime();
        this.categoryUpdatedDate = Calendar.getInstance().getTime();
    }

    public Category(
            String categoryId,
            String categoryTitle,
            int categoryResId,
            boolean isIncome,
            Date categoryCreatedDate,
            Date categoryUpdatedDate
    ) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categoryResId = categoryResId;
        this.isIncome = isIncome;
        this.categoryCreatedDate = categoryCreatedDate;
        this.categoryUpdatedDate = categoryUpdatedDate;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public int getCategoryResId() {
        return categoryResId;
    }

    public void setCategoryResId(int categoryResId) {
        this.categoryResId = categoryResId;
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

    public Date getCategoryUpdatedDate() {
        return categoryUpdatedDate;
    }

    public void setCategoryUpdatedDate(Date categoryUpdatedDate) {
        this.categoryUpdatedDate = categoryUpdatedDate;
    }

    public void updateCategory(
            String categoryTitle,
            int iconResId,
            boolean isIncome
    ) {
        this.categoryTitle = categoryTitle;
        this.categoryResId = iconResId;
        this.isIncome = isIncome;
    }
}
