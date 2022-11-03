package com.vuhm.moony.data.mapper;

import com.vuhm.moony.data.entity.TransactionItemEntity;
import com.vuhm.moony.domain.mapper.IMapper;
import com.vuhm.moony.domain.model.TransactionItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class TransactionItemMapper implements IMapper<TransactionItemEntity, TransactionItem> {

    private final TransactionMapper transactionMapper;
    private final CategoryMapper categoryMapper;
    private final SavingMapper savingMapper;

    @Inject
    public TransactionItemMapper(
            TransactionMapper transactionMapper,
            CategoryMapper categoryMapper,
            SavingMapper savingMapper
    ) {
        this.transactionMapper = transactionMapper;
        this.categoryMapper = categoryMapper;
        this.savingMapper = savingMapper;
    }

    @Override
    public TransactionItem mapFromEntity(TransactionItemEntity transactionItemEntity) {
        if (transactionItemEntity.getSaving() == null) {
            return new TransactionItem(
                    transactionMapper.mapFromEntity(transactionItemEntity.getTransaction()),
                    categoryMapper.mapFromEntity(transactionItemEntity.getCategory()),
                    null
            );
        } else {
            return new TransactionItem(
                    transactionMapper.mapFromEntity(transactionItemEntity.getTransaction()),
                    categoryMapper.mapFromEntity(transactionItemEntity.getCategory()),
                    savingMapper.mapFromEntity(transactionItemEntity.getSaving())
            );
        }

    }

    @Override
    public TransactionItemEntity mapToEntity(TransactionItem transactionItem) {
        return new TransactionItemEntity(
                transactionMapper.mapToEntity(transactionItem.getTransaction()),
                categoryMapper.mapToEntity(transactionItem.getCategory()),
                savingMapper.mapToEntity(transactionItem.getSaving())
        );
    }

    public Observable<List<TransactionItemEntity>> mapToEntityList(
            Observable<List<TransactionItem>> transactions
    ) {
        return transactions.map(models -> {
            List<TransactionItemEntity> list = new ArrayList<>();
            for (int i = 0; i < models.size(); i++) {
                list.add(mapToEntity(models.get(i)));
            }
            return list;
        });
    }

    public Observable<List<TransactionItem>> mapFromEntityList(
            Observable<List<TransactionItemEntity>> transactionEntities
    ) {
        return transactionEntities.map(entities -> {
            List<TransactionItem> list = new ArrayList<>();
            for (int i = 0; i < entities.size(); i++) {
                list.add(mapFromEntity(entities.get(i)));
            }
            return list;
        });
    }
}
