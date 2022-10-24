package com.vuhm.moony.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Entity(tableName = "saving")
public class SavingEntity {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private final String id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "goal")
    private double goal;
    @ColumnInfo(name = "created_at")
    private final Date createdAt;
    @ColumnInfo(name = "updated+at")
    private Date updatedAt;

    public SavingEntity() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = Calendar.getInstance().getTime();
        this.updatedAt = Calendar.getInstance().getTime();
    }

    public SavingEntity(
            String title,
            String description,
            double goal
    ) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.goal = goal;
        this.createdAt = Calendar.getInstance().getTime();
        this.updatedAt = Calendar.getInstance().getTime();
    }

    public SavingEntity(
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
}
