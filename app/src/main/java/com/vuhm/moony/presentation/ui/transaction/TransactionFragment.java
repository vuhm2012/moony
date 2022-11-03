package com.vuhm.moony.presentation.ui.transaction;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.vuhm.moony.R;
import com.vuhm.moony.databinding.FragmentTransactionBinding;
import com.vuhm.moony.domain.model.TransactionItem;
import com.vuhm.moony.presentation.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TransactionFragment extends BaseFragment {

    private FragmentTransactionBinding binding;
    private TransactionAdapter adapter;
    private TransactionViewModel viewModel;
    private double totalIncomes;
    private double totalExpenses;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_transaction;
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
        binding = (FragmentTransactionBinding) getBinding();
        viewModel = new ViewModelProvider(this).get(TransactionViewModel.class);

        binding.rcvTransactions.setLayoutManager(new LinearLayoutManager(baseContext));
        viewModel.getTransactions().observe(getViewLifecycleOwner(), transactionItem -> {
            totalIncomes = 0;
            totalExpenses = 0;
            for (int i = 0; i < transactionItem.size(); i++) {
                if (transactionItem.get(i).getCategory().isIncome()) {
                    totalIncomes += transactionItem.get(i).getTransaction().getAmount();
                } else {
                    totalExpenses += transactionItem.get(i).getTransaction().getAmount();
                }
            }
            binding.lbIncomeValue.setText(String.valueOf(totalIncomes));
            binding.lbExpenseValue.setText(String.valueOf(totalExpenses));
            adapter = new TransactionAdapter(requireContext(), transactionItem, data -> {
                TransactionItem item = (TransactionItem) data;
                TransactionFragmentDirections.ActionTransactionFragmentToTransactionDetailFragment action =
                        TransactionFragmentDirections.actionTransactionFragmentToTransactionDetailFragment();
                action.setTransactionId(item.getTransaction().getId());
                Navigation.findNavController(this.getView()).navigate(action);
            });
            binding.rcvTransactions.setAdapter(adapter);
        });
    }

    @Override
    public void initEvents() {
        binding.btnAddTransaction.setOnClickListener(view -> {
            getActivityViewById(R.id.bottom_bar).setVisibility(View.GONE);
            navigate(view, R.id.action_transactionFragment_to_transactionDetailFragment);
        });
    }
}
