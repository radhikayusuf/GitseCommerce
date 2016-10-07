package com.example.root.gitsecommerce.Main.RecyclerViewSetting;

import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;
import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by root on 07/10/16.
 */

public class ContentAdapter extends GitsAdapter {
    public ContentAdapter(List collection) {
        super(collection);
    }

    @Override
    public GitsRowVM createViewModel(AppCompatActivity activity, ViewDataBinding binding, Object item, int position) {
        return null;
    }

    @Override
    public int getLayoutRes() {
        return 0;
    }

    @Override
    public void render(ViewDataBinding binding, GitsRowVM viewModel, Object item) {

    }

    @Override
    public void onRowClick(Object data, int position) {

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}
