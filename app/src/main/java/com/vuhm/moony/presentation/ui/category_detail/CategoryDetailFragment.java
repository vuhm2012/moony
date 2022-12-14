package com.vuhm.moony.presentation.ui.category_detail;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.vuhm.moony.R;
import com.vuhm.moony.core.utils.OnItemClick;
import com.vuhm.moony.databinding.FragmentCategoryDetailBinding;
import com.vuhm.moony.domain.model.Category;
import com.vuhm.moony.domain.model.CategoryIcon;
import com.vuhm.moony.domain.model.TransactionItem;
import com.vuhm.moony.presentation.base.BaseFragment;
import com.vuhm.moony.presentation.ui.transaction.TransactionAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CategoryDetailFragment extends BaseFragment {

    private FragmentCategoryDetailBinding binding;
    private CategoryDetailViewModel viewModel;
    private int iconResId = -1;
    private boolean isCreate = true;
    private String categoryId;
    private Category category;
    private TransactionAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_category_detail;
    }

    @Override
    public void initControls(Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(CategoryDetailViewModel.class);
        categoryId = getArguments().getString("categoryId");
        binding = (FragmentCategoryDetailBinding) getBinding();
        binding.rdbIncome.setChecked(true);
        if (!Objects.equals(categoryId, "-1") && categoryId != null) {
            binding.btnDelete.setVisibility(View.VISIBLE);
            isCreate = false;
            viewModel.getCategoryById(categoryId).observe(getViewLifecycleOwner(), categories -> {
                category = categories.get(0);
                binding.txtTitle.setText(category.getCategoryTitle());
                binding.imgIcon.setImageResource(category.getCategoryResId());
                iconResId = category.getCategoryResId();
                if (category.isIncome()) {
                    binding.rdgIsIncome.check(R.id.rdb_income);
                } else {
                    binding.rdgIsIncome.check(R.id.rdb_expenses);
                }
            });
        }

        binding.rcvTransactions.setLayoutManager(new LinearLayoutManager(baseContext));
        viewModel.getTransactionsByCategory(categoryId).observe(getViewLifecycleOwner(), transactionItem -> {
            adapter = new TransactionAdapter(requireContext(), transactionItem, data -> {
                TransactionItem item = (TransactionItem) data;
                CategoryDetailFragmentDirections.ActionCategoryDetailFragmentToTransactionDetailFragment action =
                        CategoryDetailFragmentDirections.actionCategoryDetailFragmentToTransactionDetailFragment();
                action.setTransactionId(item.getTransaction().getTransactionId());
                Navigation.findNavController(this.getView()).navigate(action);
            });
            binding.rcvTransactions.setAdapter(adapter);
        });

        viewModel.getTransactionsByCategory(categoryId).observe(getViewLifecycleOwner(), transactionItems -> {
            for (int i = 0; i < transactionItems.size(); i++) {
                Log.d("HIHI", transactionItems.get(i).getTransaction().getTransactionTitle());
            }
        });
    }

    @Override
    public void initEvents() {
        binding.btnBack.setOnClickListener(this::pop);

        binding.btnSave.setOnClickListener(view -> {
            if (binding.txtTitle.getText().toString().isEmpty()) {
                new AlertDialog.Builder(requireContext())
                        .setTitle("Missing data")
                        .setMessage("Title must not be null")
                        .setNegativeButton(android.R.string.ok, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            } else if (iconResId == -1) {
                new AlertDialog.Builder(requireContext())
                        .setTitle("Missing data")
                        .setMessage("Icon must not be null")
                        .setNegativeButton(android.R.string.ok, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            } else {
                if (isCreate) {
                    createCategory();
                    pop(view);
                } else {
                    category.updateCategory(
                            binding.txtTitle.getText().toString(),
                            iconResId,
                            binding.rdgIsIncome.getCheckedRadioButtonId() == R.id.rdb_income
                    );
                    viewModel.updateCategory(category);
                    pop(view);
                }
            }
        });

        binding.layoutIcon.setOnClickListener(view -> {
            showDialogPickIcon(content -> {
                binding.imgIcon.setImageResource(content.getIconResId());
                iconResId = content.getIconResId();
            });
        });

        binding.btnDelete.setOnClickListener(view -> {
            new AlertDialog.Builder(requireContext())
                    .setTitle("Delete entry")
                    .setMessage("Are you sure you want to delete this entry?")
                    .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                        pop(view);
                        viewModel.deleteCategory(categoryId);
                    })
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        });

    }

    private void createCategory() {
        Category category = new Category(
                binding.txtTitle.getText().toString(),
                iconResId,
                binding.rdgIsIncome.getCheckedRadioButtonId() == R.id.rdb_income
        );
        viewModel.createCategory(category);
    }

    private void showDialogPickIcon(OnItemClick<CategoryIcon> onClick) {
        GridView gridView = new GridView(requireContext());
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(gridView);
        builder.setTitle("Choose Icon");
        builder.setCancelable(true);
        List<CategoryIcon> icons = new ArrayList();
        icons.add(new CategoryIcon("Birthday", R.drawable.ic_birthday));
        icons.add(new CategoryIcon("Bus", R.drawable.ic_bus));
        icons.add(new CategoryIcon("Celebration", R.drawable.ic_celebration));
        icons.add(new CategoryIcon("Electric", R.drawable.ic_electric));
        icons.add(new CategoryIcon("Fast food", R.drawable.ic_fast_food));
        icons.add(new CategoryIcon("Fuel", R.drawable.ic_fuel));
        icons.add(new CategoryIcon("Game", R.drawable.ic_game));
        icons.add(new CategoryIcon("Group party", R.drawable.ic_groups));
        icons.add(new CategoryIcon("House", R.drawable.ic_house));
        icons.add(new CategoryIcon("Hospital", R.drawable.ic_hospital));
        icons.add(new CategoryIcon("Hotel", R.drawable.ic_hotel));
        icons.add(new CategoryIcon("Internet", R.drawable.ic_internet));
        icons.add(new CategoryIcon("Laptop", R.drawable.ic_laptop));
        icons.add(new CategoryIcon("Medicine", R.drawable.ic_medicine));
        icons.add(new CategoryIcon("Grab, Uber, Motorbike transport service", R.drawable.ic_motorbike));
        icons.add(new CategoryIcon("Parking", R.drawable.ic_parking));
        icons.add(new CategoryIcon("Printing", R.drawable.ic_printing));
        icons.add(new CategoryIcon("Repair", R.drawable.ic_repair));
        icons.add(new CategoryIcon("School", R.drawable.ic_school));
        icons.add(new CategoryIcon("School supplies", R.drawable.ic_school_supplies));
        icons.add(new CategoryIcon("Other service", R.drawable.ic_service));
        icons.add(new CategoryIcon("Shopping", R.drawable.ic_shopping));
        icons.add(new CategoryIcon("Sickness", R.drawable.ic_sick));
        icons.add(new CategoryIcon("Cigarette", R.drawable.ic_smoke));
        icons.add(new CategoryIcon("Sport", R.drawable.ic_sport));
        icons.add(new CategoryIcon("Taxi", R.drawable.ic_taxi));
        icons.add(new CategoryIcon("Theater", R.drawable.ic_theater));
        icons.add(new CategoryIcon("Train", R.drawable.ic_train));
        icons.add(new CategoryIcon("Travel", R.drawable.ic_travel));
        icons.add(new CategoryIcon("Washing vehicle", R.drawable.ic_wash));
        icons.add(new CategoryIcon("Water", R.drawable.ic_water));
        icons.add(new CategoryIcon("Work", R.drawable.ic_work));

        AlertDialog dialog = builder.create();
        gridView.setAdapter(new IconAdapter(icons, requireContext()));
        gridView.setNumColumns(4);
        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            dialog.dismiss();
            onClick.onClick(icons.get(i));
        });
        dialog.show();
    }
}
