package com.vuhm.moony.domain.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Saving {
    private final String id;
    private String title;
    private String description;
    private double goal;
    private final Date createdAt;
    private Date updatedAt;

    public Saving() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = Calendar.getInstance().getTime();
        this.updatedAt = Calendar.getInstance().getTime();
    }

    public Saving(String title, String description, double goal) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.goal = goal;
        this.createdAt = Calendar.getInstance().getTime();
        this.updatedAt = Calendar.getInstance().getTime();
    }

    public Saving(
            String id,
            String title,
            String description,
            double goal,
            Date createdAt,
            Date updatedAt
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.goal = goal;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getGoal() {
        return goal;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void updateSaving(
            String title,
            String description,
            double goal
    ) {
        this.title = title;
        this.description = description;
        this.goal = goal;
        this.updatedAt = Calendar.getInstance().getTime();
    }
}
