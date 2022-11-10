package com.vuhm.moony.presentation.ui.saving_detail;

import androidx.lifecycle.LiveData;

import com.vuhm.moony.domain.model.Saving;
import com.vuhm.moony.domain.repository.SavingRepository;
import com.vuhm.moony.presentation.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class SavingDetailViewModel extends BaseViewModel {

    private SavingRepository repository;

    @Inject
    public SavingDetailViewModel(SavingRepository repository) {
        this.repository = repository;
    }

    public void createSaving(Saving saving) {
        repository.createSaving(saving).subscribeOn(Schedulers.io()).subscribe();
    }

    public void deleteSaving(String savingId) {
        repository.deleteSavingById(savingId).subscribeOn(Schedulers.io()).subscribe();
    }

    public LiveData<List<Saving>> getSavingById(String id) {
        return fromObservableToLiveData(repository.getSavingById(id));
    }
}
