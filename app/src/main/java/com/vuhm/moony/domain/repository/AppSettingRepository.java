package com.vuhm.moony.domain.repository;

public interface AppSettingRepository {

    Boolean isFirstTime();

    void setFirstTime(boolean isFirstTime);

}
