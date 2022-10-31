package com.vuhm.moony.presentation.ui.category;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.vuhm.moony.R;
import com.vuhm.moony.databinding.FragmentCategoryBinding;
import com.vuhm.moony.domain.model.CategoryIcon;
import com.vuhm.moony.presentation.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CategoryFragment extends BaseFragment {

    private FragmentCategoryBinding binding;
    private CategoryAdapter adapter;
    private List<CategoryIcon> icons = new ArrayList();

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
        binding = (FragmentCategoryBinding) getBinding();
        adapter = new CategoryAdapter(list, data -> {
            Toast.makeText(baseContext, "Data: " + data, Toast.LENGTH_SHORT).show();
        });
        binding.rcvCategory.setLayoutManager(new LinearLayoutManager(baseContext));
        binding.rcvCategory.setAdapter(adapter);
    }

    @Override
    public void initEvents() {
        binding.btnAddCategory.setOnClickListener(view -> {
            getActivityViewById(R.id.bottom_bar).setVisibility(View.GONE);
            navigate(view, R.id.action_categoryFragment_to_categoryDetailFragment);
        });
    }
}
