package com.example.root.gitsecommerce.Main.ViewModel;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.Core.MyObserver;
import com.example.Dao.ListDao;
import com.example.Repository.ListRepository;
import com.example.root.gitsecommerce.Constant.eCommerceApp;
import com.example.root.gitsecommerce.Main.RecyclerViewSetting.ContentAdapter;
import com.google.common.util.concurrent.AbstractScheduledService;

import java.util.ArrayList;
import java.util.List;

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
        getCommerceList();
        bAdapter = new ContentAdapter(mData);
        gridLayoutManager = new GridLayoutManager(mContext, 2);

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

            }

            @Override
            public void onApiResultOk(ListDao listDao) {
                ListDao listDao1 = listDao;
                mData = listDao.getDATA().getProducts();
            }
        }));
    }


}
