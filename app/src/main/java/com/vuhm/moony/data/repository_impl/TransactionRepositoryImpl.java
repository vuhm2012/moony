package com.vuhm.moony.data.repository_impl;

import com.vuhm.moony.data.local.TransactionDao;
import com.vuhm.moony.data.mapper.TransactionMapper;
import com.vuhm.moony.domain.model.Transaction;
import com.vuhm.moony.domain.repository.TransactionRepository;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class TransactionRepositoryImpl implements TransactionRepository {

    private final TransactionDao transactionDao;
    private final TransactionMapper transactionMapper;

    @Inject
    TransactionRepositoryImpl(TransactionDao transactionDao, TransactionMapper transactionMapper) {
        this.transactionDao = transactionDao;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public Completable createTransaction(Transaction transaction) {
        return transactionDao.createTransaction(transactionMapper.mapToEntity(transaction));
    }

    @Override
    public Completable updateTransaction(Transaction transaction) {
        return transactionDao.updateTransaction(transactionMapper.mapToEntity(transaction));
    }

    @Override
    public Completable deleteTransaction(Transaction transaction) {
        return transactionDao.deleteTransaction(transactionMapper.mapToEntity(transaction));
    }

    @Override
    public Completable deleteTransactionById(UUID transactionId) {
        return transactionDao.deleteTransactionById(transactionId);
    }

    @Override
    public Observable<List<Transaction>> getAllTransactions() {
        return transactionMapper.mapFromEntityList(transactionDao.getAllTransactions());
    }
}
