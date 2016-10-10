package com.example.root.gitsecommerce.Detail.ViewModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

//import com.example.Core.MyObserver;
import com.example.Core.CommerceApi;
import com.example.Dao.DetailDao;
import com.example.Dao.ListDao;
//import com.example.Repository.DetailRepository;
import com.example.root.gitsecommerce.Constant.Constant;
import com.example.root.gitsecommerce.Constant.eCommerceApp;
import com.example.root.gitsecommerce.Detail.ObservableDetail;
import com.example.root.gitsecommerce.Main.MainActivity;
import com.example.root.gitsecommerce.Main.RecyclerViewSetting.ContentAdapter;

import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.schedulers.Schedulers;

/**
 * Created by root on 09/10/16.
 */

public class DetailActivityVM extends GitsVM {
   // private DetailRepository mDetailRepository = new DetailRepository(eCommerceApp.getMeCommerceApi());
    public DetailDao.DATABean mData;
    public String nama = "", rating ="", desc, spec, dis, qty;
    public DetailDao.DATABean.UkuranBean ukuranBean;
    Call<DetailDao> daoCall;
    public ImageButton.OnClickListener onClickListener;
    public ObservableDetail observableDetail = new ObservableDetail("","","","");

    public DetailActivityVM(Context context,String id) {
        super(context);

        daoCall = CommerceApi.service(Constant.BASE_URL).getDetail(id);
        daoCall.enqueue(new Callback<DetailDao>() {

            @Override
            public void onResponse(Call<DetailDao> call, Response<DetailDao> response) {
                mData = response.body().getDATA();
                initComponent(mData);
            }

            @Override
            public void onFailure(Call<DetailDao> call, Throwable t) {

            }
        });

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) mContext).finish();
            }
        };
    }


    private void initComponent(DetailDao.DATABean mData) {
        observableDetail.setName(mData.getNama());
        System.out.println("Datanya"+ mData.getNama());
    }
}
