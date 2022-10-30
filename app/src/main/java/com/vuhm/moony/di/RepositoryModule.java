package com.vuhm.moony.di;

import android.content.Context;

import com.vuhm.moony.data.local.CategoryDao;
import com.vuhm.moony.data.local.SavingDao;
import com.vuhm.moony.data.local.TransactionDao;
import com.vuhm.moony.data.mapper.CategoryMapper;
import com.vuhm.moony.data.mapper.SavingMapper;
import com.vuhm.moony.data.mapper.TransactionItemMapper;
import com.vuhm.moony.data.mapper.TransactionMapper;
import com.vuhm.moony.data.repository_impl.AppSettingRepositoryImpl;
import com.vuhm.moony.data.repository_impl.CategoryRepositoryImpl;
import com.vuhm.moony.data.repository_impl.SavingRepositoryImpl;
import com.vuhm.moony.data.repository_impl.TransactionRepositoryImpl;
import com.vuhm.moony.domain.repository.AppSettingRepository;
import com.vuhm.moony.domain.repository.CategoryRepository;
import com.vuhm.moony.domain.repository.SavingRepository;
import com.vuhm.moony.domain.repository.TransactionRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {


    @Singleton
    @Provides
    TransactionRepository provideTransactionRepository(
            TransactionDao transactionDao,
            TransactionMapper transactionMapper,
            TransactionItemMapper transactionItemMapper
    ) {
        return new TransactionRepositoryImpl(transactionDao, transactionMapper, transactionItemMapper);
    }

    @Singleton
    @Provides
    CategoryRepository provideCategoryRepository(CategoryDao categoryDao, CategoryMapper categoryMapper) {
        return new CategoryRepositoryImpl(categoryDao, categoryMapper);
    }

    @Singleton
    @Provides
    SavingRepository provideSavingRepository(SavingDao savingDao, SavingMapper savingMapper) {
        return new SavingRepositoryImpl(savingDao, savingMapper);
    }

    @Singleton
    @Provides
    AppSettingRepository provideAppSettingRepository(@ApplicationContext Context context) {
        return new AppSettingRepositoryImpl(context);
    }

}
