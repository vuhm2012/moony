package com.vuhm.moony.di;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vuhm.moony.data.local.CategoryDao;
import com.vuhm.moony.data.local.MoonyDatabase;
import com.vuhm.moony.data.local.SavingDao;
import com.vuhm.moony.data.local.TransactionDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DataSourceModule {

    @Provides
    @Singleton
    public MoonyDatabase provideDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(
                        context,
                        MoonyDatabase.class,
                        MoonyDatabase.DB_NAME
                ).fallbackToDestructiveMigration()
                .enableMultiInstanceInvalidation()
                .setJournalMode(RoomDatabase.JournalMode.AUTOMATIC)
                .build();
    }

    @Provides
    @Singleton
    public TransactionDao provideTransactionDao(MoonyDatabase database) {
        return database.getTransactionDao();
    }

    @Provides
    @Singleton
    public CategoryDao provideCategoryDao(MoonyDatabase database) {
        return database.getCategoryDao();
    }

    @Provides
    @Singleton
    public SavingDao provideSavingDao(MoonyDatabase database) {
        return database.getSavingDao();
    }
}
