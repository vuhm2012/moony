package com.vuhm.moony.presentation.ui.saving_detail;

import android.os.Bundle;

import com.vuhm.moony.R;
import com.vuhm.moony.databinding.FragmentSavingDetailBinding;
import com.vuhm.moony.presentation.base.BaseFragment;

public class SavingDetailFragment extends BaseFragment {

    private FragmentSavingDetailBinding binding;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_saving_detail;
    }

    @Override
    public void initControls(Bundle savedInstanceState) {
        binding = (FragmentSavingDetailBinding) getBinding();
    }

    @Override
    public void initEvents() {
        binding.btnBack.setOnClickListener(view -> {
            pop(view);
        });
    }
}
