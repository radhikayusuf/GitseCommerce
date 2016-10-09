package com.example.root.gitsecommerce.Main.RecyclerViewSetting;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.Dao.ListDao;
import com.example.root.gitsecommerce.Detail.DetailActivity;
import com.example.root.gitsecommerce.R;
import com.example.root.gitsecommerce.databinding.CardContentRowBinding;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;
import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by root on 07/10/16.
 */

public class ContentAdapter extends GitsAdapter<ListDao.DATABean.ProductsBean,ContentVM,CardContentRowBinding>{
    public ContentAdapter(List<ListDao.DATABean.ProductsBean> collection) {
        super(collection);
    }

    @Override
    public ContentVM createViewModel(AppCompatActivity activity, CardContentRowBinding binding, ListDao.DATABean.ProductsBean item, int position) {
        return new ContentVM(activity,binding,item);
    }


    @Override
    public int getLayoutRes() {
        return R.layout.card_content_row;
    }

    @Override
    public void render(CardContentRowBinding binding, ContentVM viewModel, ListDao.DATABean.ProductsBean item) {
        binding.setVm(viewModel);
    }

    @Override
    public void onRowClick(ListDao.DATABean.ProductsBean data, int position) {
        Intent i = new Intent(mContext, DetailActivity.class);
        i.putExtra("nama", mCollection.get(position).getId());
        mContext.startActivity(i);
    }


}
