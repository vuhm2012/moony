package com.vuhm.moony.presentation.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

public abstract class BaseFragment extends Fragment {

    private ViewDataBinding binding;

    protected FragmentActivity fragmentActivity;
    protected Context baseContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        fragmentActivity = getActivity();
        baseContext = getActivity();
        initControls(savedInstanceState);
        initEvents();
        return binding.getRoot();
    }

    public abstract int getLayoutId();

    public abstract void initControls(Bundle savedInstanceState);

    public abstract void initEvents();

    public ViewDataBinding getBinding() {
        return binding;
    }

    public View getActivityViewById(int viewId) {
        return fragmentActivity.findViewById(viewId);
    }

    public void navigate(View view, int resId) {
        Navigation.findNavController(view).navigate(resId);
    }

    public void pop(View view) {
        Navigation.findNavController(view).popBackStack();
    }
}
