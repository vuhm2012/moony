package com.vuhm.moony.presentation.ui.transaction;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.vuhm.moony.R;
import com.vuhm.moony.databinding.FragmentTransactionBinding;
import com.vuhm.moony.presentation.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TransactionFragment extends BaseFragment {

    private FragmentTransactionBinding binding;
    private TransactionAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_transaction;
    }

    @Override
    public void initControls(Bundle savedInstanceState) {
        List<String> list = new ArrayList();
        list.add("Mua oto");
        list.add("Mua xe may");
        list.add("Mua nha");
        list.add("Mua may tinh");
        list.add("Mua ipad");
        list.add("Mua airpod");
        list.add("Mua dien thoai");
        list.add("Mua iphone");
        list.add("Mua oppo");
        list.add("Mua samsung");
        list.add("Mua realme");
        binding = (FragmentTransactionBinding) getBinding();
        adapter = new TransactionAdapter(list, data -> {
            Toast.makeText(baseContext, "Data: " + data, Toast.LENGTH_SHORT).show();
        });
        binding.rcvTransactions.setLayoutManager(new LinearLayoutManager(baseContext));
        binding.rcvTransactions.setAdapter(adapter);
    }

    @Override
    public void initEvents() {

    }
}
