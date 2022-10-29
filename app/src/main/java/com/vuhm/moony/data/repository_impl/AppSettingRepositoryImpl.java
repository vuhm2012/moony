package com.vuhm.moony.data.repository_impl;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.vuhm.moony.domain.repository.AppSettingRepository;

public class AppSettingRepositoryImpl implements AppSettingRepository {

    private final SharedPreferences pref;

    public AppSettingRepositoryImpl(Context context) {
        pref = context.getSharedPreferences(context.getPackageName(), AppCompatActivity.MODE_PRIVATE);
    }

    enum Key {
        FIRST_TIME
    }

    @Override
    public Boolean isFirstTime() {
        return pref.getBoolean(Key.FIRST_TIME.toString(), true);
    }

    @Override
    public void setFirstTime(boolean isFirstTime) {
        pref.edit().putBoolean(Key.FIRST_TIME.toString(), isFirstTime).apply();
    }
}
