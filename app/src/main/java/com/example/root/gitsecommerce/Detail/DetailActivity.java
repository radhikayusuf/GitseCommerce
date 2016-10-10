package com.example.root.gitsecommerce.Detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.root.gitsecommerce.Detail.ViewModel.DetailActivityVM;
import com.example.root.gitsecommerce.R;
import com.example.root.gitsecommerce.databinding.ActivityDetailBinding;

import id.gits.mvvmcore.activity.GitsActivity;

public class DetailActivity extends GitsActivity<DetailActivityVM, ActivityDetailBinding> {

    @Override
    protected int getToolbarId() {
        return 0;
    }

    @Override
    public int getResLayout() {
        return R.layout.activity_detail;
    }

    @Override
    public DetailActivityVM getViewModel() {
        Intent i = getIntent();
        System.out.println("idnya "+i.getStringExtra("id"));
        System.out.println("rating "+i.getStringExtra("rating"));
        return new DetailActivityVM(this, i.getStringExtra("id"),i.getStringExtra("rating"),i.getStringExtra("stock"));
    }

    @Override
    public void bindViewModel(ActivityDetailBinding binding, DetailActivityVM viewModel) {
        binding.setVm(viewModel);
    }
}
