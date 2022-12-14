package com.vuhm.moony.data.mapper;

import com.vuhm.moony.data.entity.TransactionEntity;
import com.vuhm.moony.domain.mapper.IMapper;
import com.vuhm.moony.domain.model.Transaction;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class TransactionMapper implements IMapper<TransactionEntity, Transaction> {
    @Override
    public Transaction mapFromEntity(TransactionEntity transaction) {
        return new Transaction(
                transaction.getTransactionId(),
                transaction.getTransactionTitle(),
                transaction.getTransactionAmount(),
                transaction.getTransactionDescription(),
                transaction.getCategoryId(),
                transaction.getSavingId(),
                transaction.getTransactionCreatedDate(),
                transaction.getTransactionUpdatedDate()
        );
    }

    @Override
    public TransactionEntity mapToEntity(Transaction transaction) {
        return new TransactionEntity(
                transaction.getTransactionId(),
                transaction.getTransactionTitle(),
                transaction.getTransactionAmount(),
                transaction.getTransactionDescription(),
                transaction.getCategoryId(),
                transaction.getSavingId(),
                transaction.getCreatedTransactionDate(),
                transaction.getUpdatedTransactionDate()
        );
    }

    public Observable<List<TransactionEntity>> mapToEntityList(
            Observable<List<Transaction>> transactions
    ) {
        return transactions.map(models -> {
            List<TransactionEntity> list = new ArrayList<>();
            for (int i = 0; i < models.size(); i++) {
                list.add(mapToEntity(models.get(i)));
            }
            return list;
        });
    }

    public Observable<List<Transaction>> mapFromEntityList(
            Observable<List<TransactionEntity>> transactionEntities
    ) {
        return transactionEntities.map(entities -> {
            List<Transaction> list = new ArrayList<>();
            for (int i = 0; i < entities.size(); i++) {
                list.add(mapFromEntity(entities.get(i)));
            }
            return list;
        });
    }
}
