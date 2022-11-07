package com.vuhm.moony.domain.repository;

import com.vuhm.moony.domain.model.Category;
import com.vuhm.moony.domain.model.TransactionItem;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface CategoryRepository {

    Completable createCategory(Category category);

    Completable updateCategory(Category category);

    Completable deleteCategory(Category category);

    Completable deleteCategoryById(String categoryId);

    Observable<List<Category>> getAllCategories();

    Single<Integer> countTransactionByCategoryId(String categoryId);

    Observable<List<Category>> getCategoryId(String categoryId);

    Observable<List<TransactionItem>> getTransactionsByCategory(String categoryId);
}
