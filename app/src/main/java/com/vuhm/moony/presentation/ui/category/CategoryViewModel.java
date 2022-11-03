package com.vuhm.moony.presentation.ui.category;

import androidx.lifecycle.LiveData;

import com.vuhm.moony.domain.model.Category;
import com.vuhm.moony.domain.repository.CategoryRepository;
import com.vuhm.moony.presentation.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class CategoryViewModel extends BaseViewModel {

    private final CategoryRepository categoryRepository;
    public int countTransaction;

    @Inject
    public CategoryViewModel(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        countTransaction = 0;
    }

    public LiveData<List<Category>> getAllCategories() {
        return fromObservableToLiveData(categoryRepository.getAllCategories());
    }

    public void countTransactionByCategoryId(String id) {
        categoryRepository.countTransactionByCategoryId(id).observeOn(Schedulers.io()).subscribe();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
