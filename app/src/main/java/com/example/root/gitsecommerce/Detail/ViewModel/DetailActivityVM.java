package com.example.root.gitsecommerce.Detail.ViewModel;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

//import com.example.Core.MyObserver;
import com.example.Dao.DetailDao;
import com.example.Dao.ListDao;
//import com.example.Repository.DetailRepository;
import com.example.root.gitsecommerce.Constant.eCommerceApp;
import com.example.root.gitsecommerce.Detail.ObservableDetail;
import com.example.root.gitsecommerce.Main.RecyclerViewSetting.ContentAdapter;

import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;
import rx.schedulers.Schedulers;

/**
 * Created by root on 09/10/16.
 */

public class DetailActivityVM extends GitsVM {
   // private DetailRepository mDetailRepository = new DetailRepository(eCommerceApp.getMeCommerceApi());
    public DetailDao.DATABean mData;
    public String nama = "", rating ="", desc, spec, dis, qty;
    public DetailDao.DATABean.UkuranBean ukuranBean;
    public ObservableDetail observableDetail = new ObservableDetail("","","","");

    public DetailActivityVM(Context context) {
        super(context);
       // getCommerceList();


    }

//    public void getCommerceList(){
//
//        addSubscription(mDetailRepository.getDetailDao("1")
//                .subscribeOn(Schedulers.io())
//                .subscribe(new MyObserver<DetailDao>(){
//
//                    @Override
//                    public void onApiResultCompleted() {
//
//
//                    }
//
//                    @Override
//                    public void onApiResultError(String message, String code) {
//                        System.out.println("pesan errornya "+message+" \ncode "+code);
//                    }
//
//                    @Override
//                    public void onApiResultOk(DetailDao detailDao) {
//                        //Log.wtf("DATA",listDao.getDATA().getProducts().get(0).getNama());
//                        mData = detailDao.getDATA();
//                        initComponent(mData);
//                    }
//
//                }));
//    }

    private void initComponent(DetailDao.DATABean mData) {
        observableDetail.setName(mData.getNama());
//        nama = mData.getNama();
//        Log.d("Datanya :", nama);
//        desc = mData.getDeskripsi();
//        spec = mData.getSpesifikasi();
//        dis = mData.getDiskon();
    }
}
