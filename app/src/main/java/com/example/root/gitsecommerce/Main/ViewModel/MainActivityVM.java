package com.example.root.gitsecommerce.Main.ViewModel;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.Core.MyObserver;
import com.example.Dao.ListDao;
import com.example.Repository.ListRepository;
import com.example.root.gitsecommerce.Constant.eCommerceApp;
import com.example.root.gitsecommerce.Main.ListFilter.FilterDialog;
import com.example.root.gitsecommerce.Main.RecyclerViewSetting.ContentAdapter;
import com.example.root.gitsecommerce.R;
import com.example.root.gitsecommerce.databinding.FilterDialogBinding;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.AbstractScheduledService;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import id.gits.mvvmcore.viewmodel.GitsVM;
import rx.schedulers.Schedulers;

/**
 * Created by root on 07/10/16.
 */

public class MainActivityVM extends GitsVM {
    public ContentAdapter bAdapter;
    public String hello = "Hello",filter = "semua",shrt = "popularity";
    public SwipeRefreshLayout swipeRefreshLayout;
    public GridLayoutManager gridLayoutManager;
    private ListRepository mListRepository;
    public Button.OnClickListener btn,btnback;
    public List<ListDao.DATABean.ProductsBean> mData = new ArrayList<>();
    public List<ListDao.DATABean.ProductsBean> mData2 = new ArrayList<>();
    public List<ListDao.DATABean.ProductsBean> mData3 = new ArrayList<>();
    public SwipeRefreshLayout.OnRefreshListener onRefreshListener;
    private static String hasil = "Gagal";
    public Dialog dialog= new Dialog(mContext);

    public MainActivityVM(final Context context) {
        super(context);
        swipeRefreshLayout = new SwipeRefreshLayout(mContext);
        mListRepository = new ListRepository(eCommerceApp.getMeCommerceApi());
        gridLayoutManager = new GridLayoutManager(mContext, 2);
        bAdapter = new ContentAdapter(mData);

        btn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btnSort){
                    dialog.setContentView(R.layout.short_dialog);
                }else {
                    dialog.setContentView(R.layout.filter_dialog);
                }dialog.setCancelable(true);
                dialog.show();
            }
        };
        btnback = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        };

       onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
           @Override
           public void onRefresh() {
               //mData.clear();
               String hasil1 = getCommerceList();
               bAdapter.notifyDataSetChanged();
               Toast.makeText(mContext,hasil1,Toast.LENGTH_SHORT).show();

           }
       };
    }



    public String getCommerceList(){

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
                hasil = "Success";
            }
        }));

        return hasil;
    }

    private void initRecycleView(List<ListDao.DATABean.ProductsBean> mData) {
        gridLayoutManager = new GridLayoutManager(mContext, 2);
            bAdapter = new ContentAdapter(mData);
            bAdapter.notifyDataSetChanged();
    }

    @BindingAdapter({"onRefresh"})
    public static void onRefresh(SwipeRefreshLayout swipeRefreshLayout, SwipeRefreshLayout.OnRefreshListener newSwipe){
        swipeRefreshLayout.setOnRefreshListener(newSwipe);
    }

    public void onClickClose(){

    }
    public void onFilterData(){
        mData3.clear();
        int i;
        switch (filter){
            case "semua" :
                mData2 = mData;
                break;
            case "gatget" :
                for (i=0;i<mData.size();i++){
                    if(mData.get(i).getJenis().equalsIgnoreCase("Gadget")){
                        mData2 = mData;
                    }
                }
                break;
            case "shirt" :
                for (i=0;i<mData.size();i++){
                    if(mData.get(i).getJenis().equalsIgnoreCase("Shirt")){
                        mData2 = mData;
                    }
                }
                break;
            case "jeans" :
                for (i=0;i<mData.size();i++){
                    if(mData.get(i).getJenis().equalsIgnoreCase("jeans")){
                        mData2 = mData;
                    }
                }
                break;
        }
        bAdapter = new ContentAdapter(mData2);
        bAdapter.notifyDataSetChanged();
    }
    //not finished
    public void onShort(){
        mData3.clear();
        switch (shrt){
            case "popularity" :
                int i;
                for(i = 0;i<mData2.size();i++){

                }
                break;
            case "lowtohigh" :
                break;
            case "hightolow" :
                break;
        }
        bAdapter = new ContentAdapter(mData3);
        bAdapter.notifyDataSetChanged();
    }


}
