package com.vuhm.moony.domain.repository;

import com.vuhm.moony.domain.model.Saving;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface SavingRepository {

    Completable createSaving(Saving saving);

    Completable updateSaving(Saving saving);

    Completable deleteSaving(Saving saving);

    Completable deleteSavingById(String savingId);

    Observable<List<Saving>> getAllSavings();

    Observable<List<Saving>> getSavingById(String savingId);
}
