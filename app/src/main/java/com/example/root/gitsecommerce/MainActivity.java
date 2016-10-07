package com.example.root.gitsecommerce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.root.gitsecommerce.ViewModel.MainActivityVM;
import com.example.root.gitsecommerce.databinding.ActivityMainBinding;

import id.gits.mvvmcore.activity.GitsActivity;

public class MainActivity extends GitsActivity<MainActivityVM, ActivityMainBinding> {


    @Override
    protected int getToolbarId() {
        return 0;
    }

    @Override
    public int getResLayout() {
        return R.layout.activity_main;
    }

    @Override
    public MainActivityVM getViewModel() {
        return new MainActivityVM(this);
    }

    @Override
    public void bindViewModel(ActivityMainBinding binding, MainActivityVM viewModel) {
        binding.setVm(viewModel);
    }
}
