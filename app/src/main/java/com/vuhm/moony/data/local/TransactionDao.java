package com.vuhm.moony.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vuhm.moony.data.entity.TransactionEntity;
import com.vuhm.moony.data.entity.TransactionItemEntity;

import java.util.List;

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
    Completable deleteTransactionById(String transactionId);

    @Query("SELECT * FROM `transaction`")
    Observable<List<TransactionEntity>> getAllTransactions();

    @Query("SELECT * FROM `transaction` " +
            "INNER JOIN `category` ON category_id = `category`.id " +
            "INNER JOIN `saving` ON saving_id = `saving`.id " +
            "WHERE category_id = :categoryId AND saving_id = :savingId")
    Observable<List<TransactionItemEntity>> getAllTransactions(String categoryId, String savingId);
}
