package com.vuhm.moony.presentation.ui.setting;

import android.os.Bundle;
import android.view.View;

import com.vuhm.moony.R;
import com.vuhm.moony.presentation.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SettingFragment extends BaseFragment {

    @Override
    public void onResume() {
        super.onResume();
        if (getActivityViewById(R.id.bottom_bar).getVisibility() == View.GONE) {
            getActivityViewById(R.id.bottom_bar).setVisibility(View.VISIBLE);
        }
    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        if (getActivityViewById(R.id.bottom_bar).getVisibility() == View.VISIBLE) {
//            getActivityViewById(R.id.bottom_bar).setVisibility(View.GONE);
//        }
//    }

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
