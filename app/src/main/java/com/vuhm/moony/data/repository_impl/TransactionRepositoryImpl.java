package com.vuhm.moony.data.repository_impl;

import com.vuhm.moony.data.local.TransactionDao;
import com.vuhm.moony.data.mapper.TransactionItemMapper;
import com.vuhm.moony.data.mapper.TransactionMapper;
import com.vuhm.moony.domain.model.Transaction;
import com.vuhm.moony.domain.model.TransactionItem;
import com.vuhm.moony.domain.repository.TransactionRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class TransactionRepositoryImpl implements TransactionRepository {

    private final TransactionDao transactionDao;
    private final TransactionMapper transactionMapper;
    private final TransactionItemMapper transactionItemMapper;

    @Inject
    public TransactionRepositoryImpl(
            TransactionDao transactionDao,
            TransactionMapper transactionMapper,
            TransactionItemMapper transactionItemMapper
    ) {
        this.transactionDao = transactionDao;
        this.transactionMapper = transactionMapper;
        this.transactionItemMapper = transactionItemMapper;
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
    public Completable deleteTransactionById(String transactionId) {
        return transactionDao.deleteTransactionById(transactionId);
    }

    @Override
    public Observable<List<Transaction>> getAllTransactions() {
        return transactionMapper.mapFromEntityList(transactionDao.getAllTransactions());
    }

    @Override
    public Observable<List<TransactionItem>> getAllTransaction() {
        return transactionItemMapper
                .mapFromEntityList(transactionDao.getAllTransaction());
    }

    @Override
    public Observable<List<TransactionItem>> getTransactionById(String id) {
        return transactionItemMapper
                .mapFromEntityList(transactionDao.getTransactionById(id));
    }
}
