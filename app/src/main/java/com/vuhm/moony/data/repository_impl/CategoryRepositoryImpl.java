package com.vuhm.moony.data.repository_impl;

import com.vuhm.moony.data.local.CategoryDao;
import com.vuhm.moony.data.mapper.CategoryMapper;
import com.vuhm.moony.domain.model.Category;
import com.vuhm.moony.domain.repository.CategoryRepository;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryDao categoryDao;
    private final CategoryMapper categoryMapper;

    @Inject
    public CategoryRepositoryImpl(CategoryDao categoryDao, CategoryMapper categoryMapper) {
        this.categoryDao = categoryDao;
        this.categoryMapper = categoryMapper;
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
    public Completable deleteCategoryById(UUID categoryId) {
        return categoryDao.deleteCategoryById(categoryId);
    }

    @Override
    public Observable<List<Category>> getAllCategories() {
        return categoryMapper.mapFromEntityList(categoryDao.getAllCategories());
    }
}
