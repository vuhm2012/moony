package com.vuhm.moony.presentation.ui.transaction_detail;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.GridView;

import androidx.lifecycle.ViewModelProvider;

import com.vuhm.moony.R;
import com.vuhm.moony.core.utils.OnItemClick;
import com.vuhm.moony.databinding.FragmentTransactionDetailBinding;
import com.vuhm.moony.domain.model.Category;
import com.vuhm.moony.domain.model.Transaction;
import com.vuhm.moony.domain.model.TransactionItem;
import com.vuhm.moony.presentation.base.BaseFragment;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TransactionDetailFragment extends BaseFragment {

    private FragmentTransactionDetailBinding binding;
    private TransactionDetailViewModel viewModel;
    private String categoryId;
    private String transactionId;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_transaction_detail;
    }

    @Override
    public void initControls(Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(TransactionDetailViewModel.class);
        transactionId = getArguments().getString("transactionId");
        binding = (FragmentTransactionDetailBinding) getBinding();
        if (!transactionId.equals("-1") && transactionId != null) {
            viewModel.getTransactionById("1bf3124b-e194-4e5e-8a22-649df745ea47").observe(getViewLifecycleOwner(), transactionItems -> {
                for (int i = 0; i < transactionItems.size(); i++) {
                    TransactionItem item = transactionItems.get(i);
                    binding.txtTitle.setText(item.getTransaction().getTitle());
                    binding.txtDescription.setText(item.getTransaction().getDescription());
                    binding.txtAmount.setText(String.valueOf(item.getTransaction().getAmount()));
                    binding.imgCategoryIcon.setImageResource(item.getCategory().getIconResId());
                }
            });
        }
    }

    @Override
    public void initEvents() {
        binding.btnBack.setOnClickListener(view -> {
            pop(view);
        });

        binding.layoutCategory.setOnClickListener(view -> {
            viewModel.getCategories().observe(getViewLifecycleOwner(), categories -> {
                showDialogPickIcon(content -> {
                    binding.imgCategoryIcon.setImageResource(content.getIconResId());
                    categoryId = content.getId();
                }, categories);
            });

        });

        binding.btnSave.setOnClickListener(view -> {
            Transaction transaction = new Transaction(
                    binding.txtTitle.getText().toString(),
                    Double.valueOf(binding.txtAmount.getText().toString()),
                    binding.txtDescription.getText().toString(),
                    categoryId
            );
            viewModel.createTransaction(transaction);
            pop(view);
        });
    }

    private void showDialogPickIcon(OnItemClick<Category> onClick, List<Category> categories) {
        GridView gridView = new GridView(requireContext());
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(gridView);
        builder.setTitle("Choose Category");
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        gridView.setAdapter(new SelectCategoryAdapter(categories, requireContext()));
        gridView.setNumColumns(1);
        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            dialog.dismiss();
            onClick.onClick(categories.get(i));
        });
        dialog.show();
    }
}
