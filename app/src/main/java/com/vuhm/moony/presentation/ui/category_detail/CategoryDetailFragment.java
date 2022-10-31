package com.vuhm.moony.presentation.ui.category_detail;

import android.os.Bundle;

import com.vuhm.moony.R;
import com.vuhm.moony.databinding.FragmentCategoryDetailBinding;
import com.vuhm.moony.presentation.base.BaseFragment;

public class CategoryDetailFragment extends BaseFragment {

    private FragmentCategoryDetailBinding binding;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_category_detail;
    }

    @Override
    public void initControls(Bundle savedInstanceState) {
        binding = (FragmentCategoryDetailBinding) getBinding();
    }

    @Override
    public void initEvents() {
        binding.btnBack.setOnClickListener(this::pop);
    }
}
