package com.example.root.gitsecommerce.Main.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.Core.MyObserver;
import com.example.Dao.ListDao;
import com.example.Repository.ListRepository;
import com.example.root.gitsecommerce.Constant.eCommerceApp;
import com.example.root.gitsecommerce.Main.ListFilter.FilterDialog;
import com.example.root.gitsecommerce.Main.ListShort.ShortDialog;
import com.example.root.gitsecommerce.Main.RecyclerViewSetting.ContentAdapter;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.AbstractScheduledService;

import java.util.ArrayList;
import java.util.List;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import id.gits.mvvmcore.viewmodel.GitsVM;
import rx.schedulers.Schedulers;

/**
 * Created by root on 07/10/16.
 */

public class MainActivityVM extends GitsVM {
    public ContentAdapter bAdapter;
    public GridLayoutManager gridLayoutManager;
    private ListRepository mListRepository;
    public List<ListDao.DATABean.ProductsBean> mData = new ArrayList<>();


    public MainActivityVM(Context context) {
        super(context);
        mListRepository = new ListRepository(eCommerceApp.getMeCommerceApi());
        gridLayoutManager = new GridLayoutManager(mContext, 2);
          bAdapter = new ContentAdapter(mData);
        getCommerceList();
    }

    void getCommerceList(){
        addSubscription(mListRepository.getListDao()
        .subscribeOn(Schedulers.io())
        .subscribe(new MyObserver<ListDao>(){

            @Override
            public void onApiResultCompleted() {


            }

            @Override
            public void onApiResultError(String message, String code) {
                System.out.println("pesan errornya "+message+" \ncode "+code);
            }

            @Override
            public void onApiResultOk(ListDao listDao) {
                Log.wtf("DATA",listDao.getDATA().getProducts().get(0).getNama());
                mData.addAll(listDao.getDATA().getProducts());
                initRecycleView(mData);
            }
        }));
    }

    private void initRecycleView(List<ListDao.DATABean.ProductsBean> mData) {
        gridLayoutManager = new GridLayoutManager(mContext, 2);
            bAdapter = new ContentAdapter(mData);
            bAdapter.notifyDataSetChanged();
    }

    public void onClickFilter(){
        Intent in = new Intent(mContext, FilterDialog.class);
        mContext.startActivity(in);
    }
    public void onClickShort(){
        Intent in = new Intent(mContext, ShortDialog.class);
        mContext.startActivity(in);
    }
}
