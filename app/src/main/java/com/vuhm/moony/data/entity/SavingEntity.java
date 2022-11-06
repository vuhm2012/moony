package com.vuhm.moony.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Entity(tableName = "saving")
@TypeConverters(DateConverter.class)
public class SavingEntity {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "saving_id")
    private String savingId;
    @ColumnInfo(name = "saving_title")
    private String savingTitle;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "goal")
    private double goal;
    @ColumnInfo(name = "saving_created_at")
    @TypeConverters(DateConverter.class)
    private Date savingCreatedAt;
    @ColumnInfo(name = "saving_updated+at")
    @TypeConverters(DateConverter.class)
    private Date savingUpdatedAt;

    public SavingEntity() {
        this.savingId = UUID.randomUUID().toString();
        this.savingCreatedAt = Calendar.getInstance().getTime();
        this.savingUpdatedAt = Calendar.getInstance().getTime();
    }

    public SavingEntity(
            String savingTitle,
            String description,
            double goal
    ) {
        this.savingId = UUID.randomUUID().toString();
        this.savingTitle = savingTitle;
        this.description = description;
        this.goal = goal;
        this.savingCreatedAt = Calendar.getInstance().getTime();
        this.savingUpdatedAt = Calendar.getInstance().getTime();
    }

    public SavingEntity(
            String savingId,
            String savingTitle,
            String description,
            double goal,
            Date savingCreatedAt,
            Date savingUpdatedAt
    ) {
        this.savingId = savingId;
        this.savingTitle = savingTitle;
        this.description = description;
        this.goal = goal;
        this.savingCreatedAt = savingCreatedAt;
        this.savingUpdatedAt = savingUpdatedAt;
    }

    @NonNull
    public String getSavingId() {
        return savingId;
    }

    public void setSavingId(@NonNull String savingId) {
        this.savingId = savingId;
    }

    public String getSavingTitle() {
        return savingTitle;
    }

    public void setSavingTitle(String savingTitle) {
        this.savingTitle = savingTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getGoal() {
        return goal;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }

    public Date getSavingCreatedAt() {
        return savingCreatedAt;
    }

    public void setSavingCreatedAt(Date savingCreatedAt) {
        this.savingCreatedAt = savingCreatedAt;
    }

    public Date getSavingUpdatedAt() {
        return savingUpdatedAt;
    }

    public void setSavingUpdatedAt(Date savingUpdatedAt) {
        this.savingUpdatedAt = savingUpdatedAt;
    }
}
