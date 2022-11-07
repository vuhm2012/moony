package com.vuhm.moony.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.vuhm.moony.data.entity.CategoryEntity;
import com.vuhm.moony.data.entity.TransactionItemEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable createCategory(CategoryEntity category);

    @Update
    Completable updateCategory(CategoryEntity category);

    @Delete
    Completable deleteCategory(CategoryEntity category);

    @Query("DELETE FROM `category` WHERE category_id = :categoryId")
    Completable deleteCategoryById(String categoryId);

    @Query("SELECT * FROM `category`")
    Observable<List<CategoryEntity>> getAllCategories();

    @Query("SELECT COUNT(transaction_id) FROM `transaction` WHERE category_id = :categoryId")
    Single<Integer> countTransactionByCategoryId(String categoryId);

    @Query("SELECT * FROM `category` WHERE category_id = :categoryId")
    Observable<List<CategoryEntity>> getCategoryById(String categoryId);

    @Query("SELECT * FROM `transaction` " +
            "INNER JOIN `category` ON `transaction`.category_id = category.category_id WHERE " +
            "`category`.category_id = :categoryId ")
    Observable<List<TransactionItemEntity>> getTransactionsByCategory(String categoryId);
}
