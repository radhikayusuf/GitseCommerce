package com.example.root.gitsecommerce.Detail.ViewModel;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

//import com.example.Core.MyObserver;
import com.example.Core.CommerceApi;
import com.example.Dao.DetailDao;
import com.example.Dao.ListDao;
//import com.example.Repository.DetailRepository;
import com.example.root.gitsecommerce.Constant.Constant;
import com.example.root.gitsecommerce.Constant.eCommerceApp;
import com.example.root.gitsecommerce.Detail.ObservableDetail;
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
    public ObservableDetail observableDetail = new ObservableDetail("","","","","","","","","", 0.0f);

    public DetailActivityVM(Context context,String id,String rate,String stock) {
        super(context);

        observableDetail.setRating(Float.parseFloat(rate));
        observableDetail.setStok("stock : "+stock);

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


    }


    private void initComponent(DetailDao.DATABean mData) {
        observableDetail.setNama(mData.getNama());
        if(!mData.getDiskon().equalsIgnoreCase("0")){
            observableDetail.setPrice("Rp "+mData.getHarga());
            double total = (Double.parseDouble(mData.getHarga()) * Double.parseDouble(mData.getDiskon())) / 100;
            observableDetail.setPricedisc("Rp "+String.valueOf(total));
        }else {
            observableDetail.setPrice("Rp "+mData.getHarga());
        }
        observableDetail.setDiscount("Discount "+mData.getDiskon()+"%");
        observableDetail.setDesc(mData.getDeskripsi());


        observableDetail.setSpec(mData.getSpesifikasi());

        StringBuffer size = new StringBuffer();
        for(int i = 0;i<mData.getUkuran().size();i++){

            size.append(mData.getUkuran().get(i).getAvailable());
            if(i < mData.getUkuran().size()){
                size.append(",");
            }

        }
        observableDetail.setSize(size.toString());


        System.out.println("Datanya"+ mData.getNama());
        System.out.println("Datanya"+ mData.getDiskon());
        System.out.println("Datanya"+ mData.getUkuran());
        System.out.println("Datanya"+ mData.getDeskripsi());
        System.out.println("Datanya"+ mData.getSpesifikasi());
    }
}
