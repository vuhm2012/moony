package com.vuhm.moony.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vuhm.moony.data.entity.CategoryEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface CategoryDao {

    @Insert
    Completable createCategory(CategoryEntity category);

    @Update
    Completable updateCategory(CategoryEntity category);

    @Delete
    Completable deleteCategory(CategoryEntity category);

    @Query("DELETE FROM `category` WHERE id = :categoryId")
    Completable deleteCategoryById(String categoryId);

    @Query("SELECT * FROM `category`")
    Observable<List<CategoryEntity>> getAllCategories();

}
