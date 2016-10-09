package com.example.root.gitsecommerce.Main.ListFilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.root.gitsecommerce.R;
import com.example.root.gitsecommerce.databinding.FilterDialogBinding;

import id.gits.mvvmcore.activity.GitsActivity;

public class FilterDialog extends GitsActivity<FilterDialogVM,FilterDialogBinding> {

    @Override
    protected int getToolbarId() {
        return 0;
    }

    @Override
    public int getResLayout() {
        return R.layout.filter_dialog;
    }

    @Override
    public FilterDialogVM getViewModel() {
        return new FilterDialogVM(this);
    }

    @Override
    public void bindViewModel(FilterDialogBinding binding, FilterDialogVM viewModel) {
        binding.setVm(viewModel);
    }
}
