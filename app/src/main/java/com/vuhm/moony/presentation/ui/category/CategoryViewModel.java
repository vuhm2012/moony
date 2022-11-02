package com.vuhm.moony.presentation.ui.category;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vuhm.moony.domain.model.Category;
import com.vuhm.moony.domain.repository.CategoryRepository;
import com.vuhm.moony.presentation.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class CategoryViewModel extends BaseViewModel {

    private final CategoryRepository categoryRepository;

    @Inject
    public CategoryViewModel(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

//    public LiveData<List<Category>> getAllCategories() {
//        return fromObservableToLiveData(categoryRepository.getAllCategories());
//    }

    private MutableLiveData<List<Category>> _categories = new MutableLiveData();
    public LiveData<List<Category>> categories = _categories;

    public void getAllCategory() {
        categoryRepository.getAllCategories().subscribeOn(Schedulers.io()).subscribe(new Observer<List<Category>>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(List<Category> categories) {
                for (int i = 0; i < categories.size(); i++) {
                    Log.d("HIHI", categories.get(i).toString());
                }

            }

            @Override
            public void onError(Throwable e) {
                Log.d("HIHI", "Error " + e);
            }

            @Override
            public void onComplete() {
                Log.d("HIHI", "Complete");
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
