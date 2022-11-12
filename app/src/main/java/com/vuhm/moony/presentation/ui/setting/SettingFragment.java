package com.vuhm.moony.presentation.ui.setting;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.vuhm.moony.R;
import com.vuhm.moony.databinding.FragmentSettingBinding;
import com.vuhm.moony.presentation.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SettingFragment extends BaseFragment {

    private FragmentSettingBinding binding;

    @Override
    public void onResume() {
        super.onResume();
        if (getActivityViewById(R.id.bottom_bar).getVisibility() == View.GONE) {
            getActivityViewById(R.id.bottom_bar).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    public void initControls(Bundle savedInstanceState) {
        binding = (FragmentSettingBinding) getBinding();
    }

    @Override
    public void initEvents() {
        binding.layoutAbout.setOnClickListener(view -> {
            openLink("https://www.facebook.com/groups/650864648771165");
        });

        binding.layoutFeedback.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://messaging/100004989875974"));
            startActivity(i);
        });

        binding.layoutForDev.setOnClickListener(view -> {
            openLink("https://github.com/vuhm2012/moony");
        });

        binding.layoutInviteFriend.setOnClickListener(view -> {
            new AlertDialog.Builder(requireContext())
                    .setTitle("Sorry")
                    .setMessage("This function is under development")
                    .setNegativeButton(android.R.string.ok, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        });

        binding.layoutRateUs.setOnClickListener(view -> {
            new AlertDialog.Builder(requireContext())
                    .setTitle("Sorry")
                    .setMessage("This function is under development")
                    .setNegativeButton(android.R.string.ok, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        });
    }

    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
