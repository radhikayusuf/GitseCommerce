package com.example.root.gitsecommerce.Main;

//import com.example.Core.MyObserver;
import com.example.Dao.ListDao;
import com.example.root.gitsecommerce.Main.ViewModel.MainActivityVM;
import com.example.root.gitsecommerce.R;
import com.example.root.gitsecommerce.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.activity.GitsActivity;
import rx.schedulers.Schedulers;

public class MainActivity extends GitsActivity<MainActivityVM, ActivityMainBinding> {

    public List<ListDao> mData = new ArrayList<>();

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
