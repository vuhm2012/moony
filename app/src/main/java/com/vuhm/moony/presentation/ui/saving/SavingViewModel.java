package com.vuhm.moony.presentation.ui.saving;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vuhm.moony.domain.model.Saving;
import com.vuhm.moony.domain.model.TransactionItem;
import com.vuhm.moony.domain.repository.SavingRepository;
import com.vuhm.moony.presentation.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
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

    public MutableLiveData<Double> _sumLiveData = new MutableLiveData();
    public LiveData<Double> sumLiveData = _sumLiveData;

    public void getSavingAmount(String id) {
        Observable<List<TransactionItem>> observable = savingRepository.getTransactionsBySaving(id);
        observable.subscribeOn(Schedulers.io()).subscribe(new DisposableObserver<List<TransactionItem>>() {
            double sum = 0;
            @Override
            public void onNext(List<TransactionItem> transactionItems) {
                for (int i = 0; i < transactionItems.size(); i++) {
                    TransactionItem transactionItem = transactionItems.get(i);
                    sum += transactionItem.getTransaction().getTransactionAmount();
                    Log.d("HIHI", String.valueOf(sum));
                }
                Log.d("HIHI", "Done OnNext");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("HIHI", e.toString());
            }

            @Override
            public void onComplete() {
                _sumLiveData.setValue(sum);
                Log.d("HIHI", "Complete");
            }
        });
    }
}
