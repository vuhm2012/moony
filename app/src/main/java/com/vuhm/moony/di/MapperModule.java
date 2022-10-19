package com.vuhm.moony.di;

import com.vuhm.moony.data.mapper.CategoryMapper;
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

}
