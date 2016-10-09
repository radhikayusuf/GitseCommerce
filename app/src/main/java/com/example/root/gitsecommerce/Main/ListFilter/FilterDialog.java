package com.example.root.gitsecommerce.Main.ListFilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.root.gitsecommerce.Main.ViewModel.MainActivityVM;
import com.example.root.gitsecommerce.R;
import com.example.root.gitsecommerce.databinding.FilterDialogBinding;

import id.gits.mvvmcore.activity.GitsActivity;

public class FilterDialog extends GitsActivity<MainActivityVM, FilterDialogBinding> {


    @Override
    protected int getToolbarId() {
        return 0;
    }

    @Override
    public int getResLayout() {
        return R.layout.filter_dialog;
    }

    @Override
    public MainActivityVM getViewModel() {
        return new MainActivityVM(this);
    }

    @Override
    public void bindViewModel(FilterDialogBinding binding, MainActivityVM viewModel) {
        binding.setVm(viewModel);
    }
}
