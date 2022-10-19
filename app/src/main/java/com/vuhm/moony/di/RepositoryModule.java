package com.vuhm.moony.di;

import com.vuhm.moony.data.local.CategoryDao;
import com.vuhm.moony.data.local.TransactionDao;
import com.vuhm.moony.data.mapper.CategoryMapper;
import com.vuhm.moony.data.mapper.TransactionMapper;
import com.vuhm.moony.data.repository_impl.CategoryRepositoryImpl;
import com.vuhm.moony.data.repository_impl.TransactionRepositoryImpl;
import com.vuhm.moony.domain.repository.CategoryRepository;
import com.vuhm.moony.domain.repository.TransactionRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {


    @Singleton
    @Provides
    TransactionRepository provideTransactionRepository(TransactionDao transactionDao, TransactionMapper transactionMapper) {
        return new TransactionRepositoryImpl(transactionDao, transactionMapper);
    }

    @Singleton
    @Provides
    CategoryRepository provideCategoryRepository(CategoryDao categoryDao, CategoryMapper categoryMapper) {
        return new CategoryRepositoryImpl(categoryDao, categoryMapper);
    }

}
