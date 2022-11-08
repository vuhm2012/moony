package com.vuhm.moony.presentation.ui.transaction_detail;

import androidx.lifecycle.LiveData;

import com.vuhm.moony.domain.model.Category;
import com.vuhm.moony.domain.model.Transaction;
import com.vuhm.moony.domain.model.TransactionItem;
import com.vuhm.moony.domain.repository.CategoryRepository;
import com.vuhm.moony.domain.repository.TransactionRepository;
import com.vuhm.moony.presentation.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class TransactionDetailViewModel extends BaseViewModel {
    private CategoryRepository categoryRepository;
    private TransactionRepository transactionRepository;

    @Inject
    public TransactionDetailViewModel(
            CategoryRepository categoryRepository,
            TransactionRepository transactionRepository
    ) {
        this.categoryRepository = categoryRepository;
        this.transactionRepository = transactionRepository;
    }

    public LiveData<List<Category>> getCategories() {
        return fromObservableToLiveData(categoryRepository.getAllCategories());
    }

    public void createTransaction(Transaction transaction) {
        transactionRepository.createTransaction(transaction).subscribeOn(Schedulers.io()).subscribe();
    }

    public void updateTransaction(Transaction transaction) {
        transactionRepository.updateTransaction(transaction).subscribeOn(Schedulers.io()).subscribe();
    }

    public void deleteTransactionById(String id) {
        transactionRepository.deleteTransactionById(id).subscribeOn(Schedulers.io()).subscribe();
    }

    public LiveData<List<TransactionItem>> getTransactionById(String id) {
        return fromObservableToLiveData(transactionRepository.getTransactionById(id));
    }
}
