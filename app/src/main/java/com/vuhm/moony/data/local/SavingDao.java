package com.vuhm.moony.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vuhm.moony.data.entity.SavingEntity;
import com.vuhm.moony.data.entity.TransactionItemEntity;

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

    @Query("DELETE FROM `saving` WHERE saving_id = :savingId")
    Completable deleteSavingById(String savingId);

    @Query("SELECT * FROM `saving`")
    Observable<List<SavingEntity>> getAllSavings();

    @Query("SELECT * FROM `saving` WHERE saving_id = :savingId")
    Observable<List<SavingEntity>> getSavingById(String savingId);

    @Query("SELECT * FROM `saving` INNER JOIN `transaction` " +
            "ON `saving`.saving_id = `transaction`.saving_id " +
            "WHERE `transaction`.saving_id = :savingId")
    Observable<List<TransactionItemEntity>> getTransactionsBySaving(String savingId);
}
