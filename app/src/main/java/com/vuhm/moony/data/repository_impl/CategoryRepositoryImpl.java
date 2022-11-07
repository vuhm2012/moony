package com.vuhm.moony.data.repository_impl;

import com.vuhm.moony.data.local.CategoryDao;
import com.vuhm.moony.data.mapper.CategoryMapper;
import com.vuhm.moony.data.mapper.TransactionItemMapper;
import com.vuhm.moony.domain.model.Category;
import com.vuhm.moony.domain.model.TransactionItem;
import com.vuhm.moony.domain.repository.CategoryRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryDao categoryDao;
    private final CategoryMapper categoryMapper;
    private final TransactionItemMapper transactionItemMapper;

    @Inject
    public CategoryRepositoryImpl(
            CategoryDao categoryDao,
            CategoryMapper categoryMapper,
            TransactionItemMapper transactionItemMapper
    ) {
        this.categoryDao = categoryDao;
        this.categoryMapper = categoryMapper;
        this.transactionItemMapper = transactionItemMapper;
    }

    @Override
    public Completable createCategory(Category category) {
        return categoryDao.createCategory(categoryMapper.mapToEntity(category));
    }

    @Override
    public Completable updateCategory(Category category) {
        return categoryDao.updateCategory(categoryMapper.mapToEntity(category));
    }

    @Override
    public Completable deleteCategory(Category category) {
        return categoryDao.deleteCategory(categoryMapper.mapToEntity(category));
    }

    @Override
    public Completable deleteCategoryById(String categoryId) {
        return categoryDao.deleteCategoryById(categoryId);
    }

    @Override
    public Observable<List<Category>> getAllCategories() {
        return categoryMapper.mapFromEntityList(categoryDao.getAllCategories());
    }

    @Override
    public Single<Integer> countTransactionByCategoryId(String categoryId) {
        return categoryDao.countTransactionByCategoryId(categoryId);
    }

    @Override
    public Observable<List<Category>> getCategoryId(String categoryId) {
        return categoryMapper.mapFromEntityList(categoryDao.getCategoryById(categoryId));
    }

    @Override
    public Observable<List<TransactionItem>> getTransactionsByCategory(String categoryId) {
        return transactionItemMapper.mapFromEntityList(categoryDao.getTransactionsByCategory(categoryId));
    }

}
