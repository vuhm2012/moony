package com.vuhm.moony.presentation.ui.saving;

import androidx.lifecycle.LiveData;

import com.vuhm.moony.domain.model.Saving;
import com.vuhm.moony.domain.model.TransactionItem;
import com.vuhm.moony.domain.repository.SavingRepository;
import com.vuhm.moony.presentation.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class SavingViewModel extends BaseViewModel {

    private SavingRepository savingRepository;

    @Inject
    public SavingViewModel(SavingRepository savingRepository) {
        this.savingRepository = savingRepository;
    }

    public LiveData<List<Saving>> getAllSavings() {
        return fromObservableToLiveData(savingRepository.getAllSavings());
    }

    public LiveData<List<Saving>> getSavingById(String savingId) {
        return fromObservableToLiveData(savingRepository.getSavingById(savingId));
    }

//    public double getSavingAmount(String id) {
//        savingRepository.getTransactionsBySaving(id).subscribeOn(Schedulers.io()).subscribe(transactionItems -> {
//            double sum = 0;
//            for (int i = 0; i < transactionItems.size(); i++) {
//                TransactionItem transactionItem = transactionItems.get(i);
//                sum += transactionItem.getTransaction().getTransactionAmount();
//            }
//            return sum;
//        });
//    }
}
