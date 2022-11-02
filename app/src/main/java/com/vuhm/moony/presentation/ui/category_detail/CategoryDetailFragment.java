package com.vuhm.moony.presentation.ui.category_detail;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.vuhm.moony.R;
import com.vuhm.moony.databinding.FragmentCategoryDetailBinding;
import com.vuhm.moony.domain.model.Category;
import com.vuhm.moony.presentation.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CategoryDetailFragment extends BaseFragment {

    private FragmentCategoryDetailBinding binding;
    private CategoryDetailViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_category_detail;
    }

    @Override
    public void initControls(Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(CategoryDetailViewModel.class);
        binding = (FragmentCategoryDetailBinding) getBinding();
    }

    @Override
    public void initEvents() {
        binding.btnBack.setOnClickListener(this::pop);
        binding.btnSave.setOnClickListener(view -> {
            createCategory();
            Toast.makeText(requireContext(), "Save", Toast.LENGTH_SHORT).show();
        });
    }

    private void createCategory() {
        Category category = new Category(
                "Ahihi",
                -1,
                true
        );
        viewModel.createCategory(category);
        Log.d("HIHI", category.getId());
    }
}
