package com.vuhm.moony.presentation.ui.category_detail;

import com.vuhm.moony.domain.model.Category;
import com.vuhm.moony.domain.repository.CategoryRepository;
import com.vuhm.moony.presentation.base.BaseViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class CategoryDetailViewModel extends BaseViewModel {

    private CategoryRepository categoryRepository;

    @Inject
    public CategoryDetailViewModel(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(Category category) {
        categoryRepository.createCategory(category).subscribeOn(Schedulers.io()).subscribe();
    }

    public void updateCategory(Category category) {
        categoryRepository.updateCategory(category).subscribeOn(Schedulers.io()).subscribe();
    }

    public void deleteCategory(String id) {
        categoryRepository.deleteCategoryById(id).subscribeOn(Schedulers.io()).subscribe();
    }
}
