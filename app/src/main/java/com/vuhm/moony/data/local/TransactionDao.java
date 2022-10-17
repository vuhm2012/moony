package com.vuhm.moony.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vuhm.moony.data.entity.TransactionEntity;

import java.util.List;
import java.util.UUID;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface TransactionDao {

    @Insert
    Completable createTransaction(TransactionEntity transaction);

    @Update
    Completable updateTransaction(TransactionEntity transaction);

    @Delete
    Completable deleteTransaction(TransactionEntity transaction);

    @Query("DELETE FROM `transaction` WHERE id = :transactionId")
    Completable deleteTransactionById(UUID transactionId);

    @Query("SELECT * FROM `transaction`")
    Observable<List<TransactionEntity>> getAllTransactions();


}
