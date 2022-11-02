package com.vuhm.moony.presentation.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public abstract class BaseViewModel extends ViewModel {

    protected Disposable disposable;

    protected <T> LiveData<T> fromObservableToLiveData(
            Observable<T> observable
    ) {
        return LiveDataReactiveStreams
                .fromPublisher(observable.toFlowable(BackpressureStrategy.LATEST));
    }

}
