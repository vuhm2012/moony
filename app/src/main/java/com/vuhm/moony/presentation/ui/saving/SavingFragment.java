package com.vuhm.moony.presentation.ui.saving;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.vuhm.moony.R;
import com.vuhm.moony.databinding.FragmentSavingBinding;
import com.vuhm.moony.domain.model.Saving;
import com.vuhm.moony.presentation.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SavingFragment extends BaseFragment {

    private FragmentSavingBinding binding;
    private SavingAdapter adapter;
    private SavingViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_saving;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivityViewById(R.id.bottom_bar).getVisibility() == View.GONE) {
            getActivityViewById(R.id.bottom_bar).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void initControls(Bundle savedInstanceState) {
        binding = (FragmentSavingBinding) getBinding();
        viewModel = new ViewModelProvider(this).get(SavingViewModel.class);
        viewModel.getAllSavings().observe(getViewLifecycleOwner(), savings -> {
            adapter = new SavingAdapter(savings, data -> {
                Saving item = (Saving) data;
                SavingFragmentDirections.ActionSavingFragmentToSavingDetailFragment action =
                        SavingFragmentDirections.actionSavingFragmentToSavingDetailFragment();
                action.setSavingId(item.getId());
                Navigation.findNavController(this.getView()).navigate(action);
            });
            binding.rcvSavings.setLayoutManager(new LinearLayoutManager(baseContext));
            binding.rcvSavings.setAdapter(adapter);
        });
    }

    @Override
    public void initEvents() {
        binding.btnAddSaving.setOnClickListener(view -> {
            getActivityViewById(R.id.bottom_bar).setVisibility(View.GONE);
            navigate(view, R.id.action_savingFragment_to_savingDetailFragment);
        });
    }
}
