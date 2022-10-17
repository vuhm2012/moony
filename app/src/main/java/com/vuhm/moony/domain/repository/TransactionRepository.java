package com.vuhm.moony.domain.repository;

import com.vuhm.moony.domain.model.Transaction;

import java.util.List;
import java.util.UUID;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface TransactionRepository {

    Completable createTransaction(Transaction transaction);

    Completable updateTransaction(Transaction transaction);

    Completable deleteTransaction(Transaction transaction);

    Completable deleteTransactionById(UUID transactionId);

    Observable<List<Transaction>> getAllTransactions();

}
