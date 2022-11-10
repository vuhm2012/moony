package com.vuhm.moony.presentation.ui.saving_detail;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.vuhm.moony.R;
import com.vuhm.moony.databinding.FragmentSavingDetailBinding;
import com.vuhm.moony.domain.model.Saving;
import com.vuhm.moony.presentation.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SavingDetailFragment extends BaseFragment {

    private FragmentSavingDetailBinding binding;
    private SavingDetailViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_saving_detail;
    }

    @Override
    public void initControls(Bundle savedInstanceState) {
        binding = (FragmentSavingDetailBinding) getBinding();
        viewModel = new ViewModelProvider(this).get(SavingDetailViewModel.class);
    }

    @Override
    public void initEvents() {
        binding.btnBack.setOnClickListener(view -> {
            pop(view);
        });

        binding.btnSave.setOnClickListener(view -> {
            Saving saving = new Saving(
                    binding.txtTitle.getText().toString(),
                    binding.txtDescription.getText().toString(),
                    Double.parseDouble(binding.txtGoal.getText().toString())
            );
            viewModel.createSaving(saving);
            pop(view);
        });
    }
}
