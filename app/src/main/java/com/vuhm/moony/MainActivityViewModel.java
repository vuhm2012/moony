package com.vuhm.moony;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vuhm.moony.domain.repository.AppSettingRepository;
import com.vuhm.moony.presentation.base.BaseViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainActivityViewModel extends BaseViewModel {

    private final AppSettingRepository repository;

    private MutableLiveData<Boolean> _isFirstTime = new MutableLiveData();
    public LiveData<Boolean> isFirstTime = _isFirstTime;

    @Inject
    public MainActivityViewModel(AppSettingRepository repository) {
        this.repository = repository;
        _isFirstTime.setValue(repository.isFirstTime());
    }

    public void setFirstTime(boolean isFirstTime) {
        repository.setFirstTime(isFirstTime);
        _isFirstTime.setValue(repository.isFirstTime());
    }
}
