package com.vuhm.moony.presentation.ui.setting;

import android.os.Bundle;

import com.vuhm.moony.R;
import com.vuhm.moony.presentation.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SettingFragment extends BaseFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    public void initControls(Bundle savedInstanceState) {

    }

    @Override
    public void initEvents() {

    }
}
