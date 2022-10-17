package com.vuhm.moony.domain.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Category {
    private final UUID id;
    private String title;
    private int iconResId;
    private boolean isIncome;
    private final Date createdDate;
    private Date updatedDate;

    public Category() {
        this.id = UUID.randomUUID();
        this.createdDate = Calendar.getInstance().getTime();
        this.updatedDate = Calendar.getInstance().getTime();
    }

    public Category(String title, int iconResId, boolean isIncome) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.iconResId = iconResId;
        this.isIncome = isIncome;
        this.createdDate = Calendar.getInstance().getTime();
        this.updatedDate = Calendar.getInstance().getTime();
    }

    public Category(UUID id, String title, int iconResId, boolean isIncome, Date createdDate, Date updatedDate) {
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

    public void updateCategory(String title, int iconResId, boolean isIncome) {
        this.title = title;
        this.iconResId = iconResId;
        this.isIncome = isIncome;
        this.updatedDate = Calendar.getInstance().getTime();
    }
}
