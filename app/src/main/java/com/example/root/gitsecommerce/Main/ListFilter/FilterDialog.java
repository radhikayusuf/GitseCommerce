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
        return 0;
    }

    @Override
    public MainActivityVM getViewModel() {
        return null;
    }

    @Override
    public void bindViewModel(FilterDialogBinding binding, MainActivityVM viewModel) {

    }
}
