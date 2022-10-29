package com.vuhm.moony.di;

import com.vuhm.moony.data.mapper.CategoryMapper;
import com.vuhm.moony.data.mapper.SavingMapper;
import com.vuhm.moony.data.mapper.TransactionItemMapper;
import com.vuhm.moony.data.mapper.TransactionMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class MapperModule {

    @Singleton
    @Provides
    TransactionMapper provideTransactionMapper() {
        return new TransactionMapper();
    }

    @Singleton
    @Provides
    CategoryMapper provideCategoryMapper() {
        return new CategoryMapper();
    }

    @Singleton
    @Provides
    SavingMapper provideSavingMapper() {
        return new SavingMapper();
    }

    @Singleton
    @Provides
    TransactionItemMapper provideTransactionItemMapper(
            TransactionMapper transactionMapper,
            CategoryMapper categoryMapper,
            SavingMapper savingMapper
    ) {
        return new TransactionItemMapper(
                transactionMapper,
                categoryMapper,
                savingMapper
        );
    }

}
