package com.vuhm.moony.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.vuhm.moony.data.entity.CategoryEntity;
import com.vuhm.moony.data.entity.SavingEntity;
import com.vuhm.moony.data.entity.TransactionEntity;

@Database(
        entities = {
                TransactionEntity.class,
                CategoryEntity.class,
                SavingEntity.class
        }, version = 1
)
public abstract class MoonyDatabase extends RoomDatabase {
    public static final String DB_NAME = "moony_db";

    public abstract TransactionDao getTransactionDao();

    public abstract CategoryDao getCategoryDao();

    public abstract SavingDao getSavingDao();
}
