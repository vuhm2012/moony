package com.vuhm.moony.domain.repository;

import com.vuhm.moony.domain.model.Transaction;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface TransactionRepository {

    Completable createTransaction(Transaction transaction);

    Completable updateTransaction(Transaction transaction);

    Completable deleteTransaction(Transaction transaction);

    Completable deleteTransactionById(String transactionId);

    Observable<List<Transaction>> getAllTransactions();

}
