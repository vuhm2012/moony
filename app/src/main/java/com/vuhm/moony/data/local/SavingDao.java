package com.vuhm.moony.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vuhm.moony.data.entity.SavingEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface SavingDao {
    @Insert
    Completable createSaving(SavingEntity saving);

    @Update
    Completable updateSaving(SavingEntity saving);

    @Delete
    Completable deleteSaving(SavingEntity saving);

    @Query("DELETE FROM `category` WHERE id = :savingId")
    Completable deleteSavingById(String savingId);

    @Query("SELECT * FROM `saving`")
    Observable<List<SavingEntity>> getAllSavings();
}
