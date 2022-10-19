package com.vuhm.moony.presentation.ui.transaction;

import android.os.Bundle;

import com.vuhm.moony.R;
import com.vuhm.moony.databinding.FragmentTransactionBinding;
import com.vuhm.moony.presentation.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TransactionFragment extends BaseFragment {

    private FragmentTransactionBinding binding;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_transaction;
    }

    @Override
    public void initControls(Bundle savedInstanceState) {
        binding = (FragmentTransactionBinding) getBinding();
    }

    @Override
    public void initEvents() {

    }
}
