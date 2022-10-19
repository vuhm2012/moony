package com.vuhm.moony.presentation.ui.category;

import android.os.Bundle;

import com.vuhm.moony.R;
import com.vuhm.moony.presentation.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CategoryFragment extends BaseFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    public void initControls(Bundle savedInstanceState) {

    }

    @Override
    public void initEvents() {

    }
}
