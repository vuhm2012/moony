package com.vuhm.moony.data.repository_impl;

import com.vuhm.moony.data.local.SavingDao;
import com.vuhm.moony.data.mapper.SavingMapper;
import com.vuhm.moony.domain.model.Saving;
import com.vuhm.moony.domain.repository.SavingRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class SavingRepositoryImpl implements SavingRepository {

    private final SavingDao savingDao;
    private final SavingMapper savingMapper;

    @Inject
    public SavingRepositoryImpl(SavingDao savingDao, SavingMapper savingMapper) {
        this.savingDao = savingDao;
        this.savingMapper = savingMapper;
    }

    @Override
    public Completable createSaving(Saving saving) {
        return savingDao.createSaving(savingMapper.mapToEntity(saving));
    }

    @Override
    public Completable updateSaving(Saving saving) {
        return savingDao.updateSaving(savingMapper.mapToEntity(saving));
    }

    @Override
    public Completable deleteSaving(Saving saving) {
        return savingDao.deleteSaving(savingMapper.mapToEntity(saving));
    }

    @Override
    public Completable deleteSavingById(String savingId) {
        return savingDao.deleteSavingById(savingId);
    }

    @Override
    public Observable<List<Saving>> getAllSavings() {
        return savingMapper.mapFromEntityList(savingDao.getAllSavings());
    }
}
