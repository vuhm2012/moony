package com.vuhm.moony.domain.repository;

import com.vuhm.moony.domain.model.Category;

import java.util.List;
import java.util.UUID;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface CategoryRepository {

    Completable createCategory(Category category);

    Completable updateCategory(Category category);

    Completable deleteCategory(Category category);

    Completable deleteCategoryById(UUID categoryId);

    Observable<List<Category>> getAllCategories();

}
