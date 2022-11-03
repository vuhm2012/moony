package com.vuhm.moony.presentation.ui.transaction;

import androidx.lifecycle.LiveData;

import com.vuhm.moony.domain.model.TransactionItem;
import com.vuhm.moony.domain.repository.TransactionRepository;
import com.vuhm.moony.presentation.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TransactionViewModel extends BaseViewModel {
    private TransactionRepository transactionRepository;

    @Inject
    public TransactionViewModel(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public LiveData<List<TransactionItem>> getTransactions() {
        return fromObservableToLiveData(transactionRepository.getAllTransaction());
    }

}
