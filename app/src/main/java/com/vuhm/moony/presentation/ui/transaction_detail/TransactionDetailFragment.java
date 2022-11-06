package com.vuhm.moony.presentation.ui.transaction_detail;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
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
    private boolean isCreate = true;
    private Transaction transaction;

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
            isCreate = false;
            viewModel.getTransactionById(transactionId).observe(getViewLifecycleOwner(), transactionItems -> {
                TransactionItem transactionItem = transactionItems.get(0);
                transaction = new Transaction(
                        transactionItem.getTransaction().getTransactionId(),
                        transactionItem.getTransaction().getTransactionTitle(),
                        transactionItem.getTransaction().getTransactionAmount(),
                        transactionItem.getTransaction().getTransactionDescription(),
                        transactionItem.getTransaction().getCategoryId(),
                        transactionItem.getTransaction().getSavingId(),
                        transactionItem.getTransaction().getCreatedTransactionDate(),
                        transactionItem.getTransaction().getUpdatedTransactionDate()
                );
                categoryId = transaction.getCategoryId();
                binding.txtTitle.setText(transactionItem.getTransaction().getTransactionTitle());
                binding.txtDescription.setText(transactionItem.getTransaction().getTransactionDescription());
                binding.lbCategoryTitle.setText(transactionItem.getCategory().getCategoryTitle());
                binding.txtAmount.setText(String.valueOf(transactionItem.getTransaction().getTransactionAmount()));
                binding.imgCategoryIcon.setImageResource(transactionItem.getCategory().getCategoryResId());
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
                    binding.imgCategoryIcon.setImageResource(content.getCategoryResId());
                    binding.lbCategoryTitle.setText(content.getCategoryTitle());
                    categoryId = content.getCategoryId();
                }, categories);
            });

        });

        binding.btnSave.setOnClickListener(view -> {
            String title = binding.txtTitle.getText().toString();
            double amount = Double.parseDouble(binding.txtAmount.getText().toString());
            String description = binding.txtDescription.getText().toString();
            if (isCreate) {
                transaction = new Transaction(
                        title,
                        amount,
                        description,
                        categoryId
                );
                viewModel.createTransaction(transaction);
                pop(view);
            } else {
                transaction.updateTransaction(
                        title,
                        description,
                        amount,
                        categoryId
                );
                Log.d("HIHI", transaction.getTransactionTitle());
                viewModel.updateTransaction(transaction);
                Log.d("HIHI", transaction.getTransactionTitle());
                pop(view);
            }
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
