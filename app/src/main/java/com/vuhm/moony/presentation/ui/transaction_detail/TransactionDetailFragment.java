package com.vuhm.moony.presentation.ui.transaction_detail;

import android.os.Bundle;

import com.vuhm.moony.R;
import com.vuhm.moony.databinding.FragmentTransactionDetailBinding;
import com.vuhm.moony.presentation.base.BaseFragment;

public class TransactionDetailFragment extends BaseFragment {

    private FragmentTransactionDetailBinding binding;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_transaction_detail;
    }

    @Override
    public void initControls(Bundle savedInstanceState) {
        binding = (FragmentTransactionDetailBinding) getBinding();
    }

    @Override
    public void initEvents() {
        binding.btnBack.setOnClickListener(view -> {
            pop(view);
        });
    }
}
