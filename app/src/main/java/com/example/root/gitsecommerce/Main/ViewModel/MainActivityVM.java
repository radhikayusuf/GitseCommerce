package com.example.root.gitsecommerce.Main.ViewModel;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.Core.MyObserver;
import com.example.Dao.ListDao;
import com.example.Repository.ListRepository;
import com.example.root.gitsecommerce.Constant.eCommerceApp;
import com.example.root.gitsecommerce.Main.RecyclerViewSetting.ContentAdapter;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.AbstractScheduledService;

import java.util.ArrayList;
import java.util.List;
import android.os.Handler;
import android.util.Log;

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
    Handler handler = new Handler();

    public MainActivityVM(Context context) {
        super(context);
        //getCommerceList();
        mListRepository = new ListRepository(eCommerceApp.getMeCommerceApi());
        gridLayoutManager = new GridLayoutManager(mContext, 2);
          bAdapter = new ContentAdapter(mData);
//        new getData().execute();
        //bAdapter = new ContentAdapter(mData);

        getCommerceList();
//        handler.postDelayed(runnable,3000);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
//            System.out.println(""+mData.get(0).getDATA().getProducts());
//            gridLayoutManager = new GridLayoutManager(mContext, 2);
//            bAdapter = new ContentAdapter(mData.get(0).getDATA().getProducts());
//            bAdapter.notifyDataSetChanged();
        }
    };
    public class getData extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            getCommerceList();
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            System.out.println(""+mData.size());
//            gridLayoutManager = new GridLayoutManager(mContext, 2);
//            bAdapter = new ContentAdapter(mData.get(0).getDATA().getProducts());
//            bAdapter.notifyDataSetChanged();
        }
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



}
