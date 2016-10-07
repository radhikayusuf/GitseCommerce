package com.example.root.gitsecommerce.Main.RecyclerViewSetting;

import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.Dao.ContentDao;
import com.example.Dao.ListDao;
import com.example.root.gitsecommerce.R;
import com.example.root.gitsecommerce.databinding.CardContentRowBinding;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;
import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by root on 07/10/16.
 */

public class ContentAdapter extends GitsAdapter<ContentDao.ListProduct,ContentVM,CardContentRowBinding>{
    public ContentAdapter(ContentDao.ListProduct collection) {
        super(collection);
    }

    @Override
    public ContentVM createViewModel(AppCompatActivity activity, CardContentRowBinding binding, ContentDao.ListProduct item, int position) {
        return new ContentVM(activity,binding,item);
    }


    @Override
    public int getLayoutRes() {
        return R.layout.card_content_row;
    }

    @Override
    public void render(CardContentRowBinding binding, ContentVM viewModel, ContentDao.ListProduct item) {
        binding.setVm(viewModel);
    }

    @Override
    public void onRowClick(ContentDao.ListProduct data, int position) {

    }


}
