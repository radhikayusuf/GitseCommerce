package com.example.root.gitsecommerce.Main.ListShort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.root.gitsecommerce.Main.MainActivity;
import com.example.root.gitsecommerce.Main.ViewModel.MainActivityVM;
import com.example.root.gitsecommerce.R;
import com.example.root.gitsecommerce.databinding.ShortDialogBinding;

import id.gits.mvvmcore.activity.GitsActivity;

public class ShortDialog extends GitsActivity<MainActivityVM,ShortDialogBinding> {

    @Override
    protected int getToolbarId() {
        return 0;
    }

    @Override
    public int getResLayout() {
        return R.layout.short_dialog;
    }

    @Override
    public MainActivityVM getViewModel() {
        return new MainActivityVM(this);
    }

    @Override
    public void bindViewModel(ShortDialogBinding binding, MainActivityVM viewModel) {
        binding.setVm(viewModel);
    }
}
