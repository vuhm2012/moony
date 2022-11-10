package com.vuhm.moony.presentation.ui.saving_detail;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

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
    private String savingId;
    private Saving saving;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_saving_detail;
    }

    @Override
    public void initControls(Bundle savedInstanceState) {
        binding = (FragmentSavingDetailBinding) getBinding();
        savingId = getArguments().getString("savingId");
        viewModel = new ViewModelProvider(this).get(SavingDetailViewModel.class);
        if (!savingId.equals("-1") && savingId != null) {
            binding.btnDelete.setVisibility(View.VISIBLE);
            viewModel.getSavingById(savingId).observe(getViewLifecycleOwner(), savings -> {
                saving = savings.get(0);
                binding.txtTitle.setText(saving.getTitle());
                binding.txtDescription.setText(saving.getDescription());
                binding.txtGoal.setText(String.valueOf(saving.getGoal()));
            });
        }
    }

    @Override
    public void initEvents() {
        binding.btnBack.setOnClickListener(this::pop);

        binding.btnSave.setOnClickListener(view -> {
            Saving saving = new Saving(
                    binding.txtTitle.getText().toString(),
                    binding.txtDescription.getText().toString(),
                    Double.parseDouble(binding.txtGoal.getText().toString())
            );
            viewModel.createSaving(saving);
            pop(view);
        });

        binding.btnDelete.setOnClickListener(view -> {
            new AlertDialog.Builder(requireContext())
                    .setTitle("Delete entry")
                    .setMessage("Are you sure you want to delete this entry?")
                    .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                        viewModel.deleteSaving(savingId);
                        pop(view);
                    })
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        });
    }
}
