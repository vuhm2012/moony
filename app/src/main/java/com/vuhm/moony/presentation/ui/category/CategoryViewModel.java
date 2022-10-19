package com.vuhm.moony.presentation.ui.category;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vuhm.moony.domain.model.Category;
import com.vuhm.moony.domain.repository.CategoryRepository;
import com.vuhm.moony.presentation.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class CategoryViewModel extends BaseViewModel {

    private final CategoryRepository categoryRepository;

    @Inject
    public CategoryViewModel(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private MutableLiveData<List<Category>> _categories = new MutableLiveData();
    public LiveData<List<Category>> categories = _categories;

    public LiveData<List<Category>> getAllCategories() {
        return fromObservableToLiveData(categoryRepository.getAllCategories());
    }
}
