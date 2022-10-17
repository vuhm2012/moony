package com.vuhm.moony.di;

import com.vuhm.moony.data.mapper.TransactionMapper;
import com.vuhm.moony.domain.mapper.IMapper;

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
    IMapper provideTransactionMapper() {
        return new TransactionMapper();
    }

}
