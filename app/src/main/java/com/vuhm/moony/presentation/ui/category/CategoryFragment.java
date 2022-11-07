package com.vuhm.moony.presentation.ui.category;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.vuhm.moony.R;
import com.vuhm.moony.databinding.FragmentCategoryBinding;
import com.vuhm.moony.domain.model.Category;
import com.vuhm.moony.presentation.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CategoryFragment extends BaseFragment {

    private FragmentCategoryBinding binding;
    private CategoryAdapter adapter;
    private CategoryViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_category;
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
        viewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        binding = (FragmentCategoryBinding) getBinding();
        binding.rcvCategory.setLayoutManager(new LinearLayoutManager(baseContext));
        viewModel.getAllCategories().observe(getViewLifecycleOwner(), categories -> {
            if (categories.size() == 0) {
                binding.imgNoData.setVisibility(View.VISIBLE);
            } else {
                adapter = new CategoryAdapter(requireContext(), categories, data -> {
                    Category category = (Category) data;
                    CategoryFragmentDirections.ActionCategoryFragmentToCategoryDetailFragment action =
                            CategoryFragmentDirections.actionCategoryFragmentToCategoryDetailFragment();
                    Log.d("HIHI", "Param: " + category.getCategoryId());
                    action.setCategoryId(category.getCategoryId());
                    Navigation.findNavController(this.getView()).navigate(action);
                });
                binding.rcvCategory.setAdapter(adapter);
            }
        });
    }

    @Override
    public void initEvents() {
        binding.btnAddCategory.setOnClickListener(view -> {
            getActivityViewById(R.id.bottom_bar).setVisibility(View.GONE);
            navigate(view, R.id.action_categoryFragment_to_categoryDetailFragment);
        });
    }
}
