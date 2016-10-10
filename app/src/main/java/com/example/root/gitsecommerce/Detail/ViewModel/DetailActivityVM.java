package com.example.root.gitsecommerce.Detail.ViewModel;

import android.app.Activity;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.Core.MyObserver;
import com.example.Core.CommerceApi;
import com.example.Dao.DetailDao;
import com.example.Dao.ListDao;
//import com.example.Repository.DetailRepository;
import com.example.root.gitsecommerce.Constant.Constant;
import com.example.root.gitsecommerce.Constant.eCommerceApp;
import com.example.root.gitsecommerce.Detail.ObservableDetail;
import com.example.root.gitsecommerce.Main.RecyclerViewSetting.ContentAdapter;
import com.example.root.gitsecommerce.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
    public ObservableField<Boolean> isGoneDesc = new ObservableField<>();
    public ObservableField<Boolean> isGoneSize = new ObservableField<>();
    public ObservableField<Boolean> isGoneSpec = new ObservableField<>();
    public ImageButton.OnClickListener onClickListener;
    public ObservableDetail observableDetail = new ObservableDetail("", "", "", "", "", "", "", "", "", 0.0f);

    public DetailActivityVM(final Context context, String id, String rate, String stock) {
        super(context);

        isGoneDesc.set(false);
        isGoneSize.set(false);
        isGoneSpec.set(false);

        observableDetail.setRating(Float.parseFloat(rate));
        observableDetail.setStok("stocknya : "+stock);

        List<DetailDao.DATABean.UkuranBean> list = new ArrayList<DetailDao.DATABean.UkuranBean>();
        list.add(new DetailDao.DATABean.UkuranBean("XL"));
        list.add(new DetailDao.DATABean.UkuranBean("L"));
        list.add(new DetailDao.DATABean.UkuranBean("M"));
        list.add(new DetailDao.DATABean.UkuranBean("S"));
        mData = new DetailDao.DATABean("Jogger Pant", "100000", "10", "Celana Terbaik Abad ini",null, list);
        initComponent(mData);

        daoCall = CommerceApi.service(Constant.BASE_URL).getDetail(id);
        daoCall.enqueue(new Callback<DetailDao>() {

            @Override
            public void onResponse(Call<DetailDao> call, Response<DetailDao> response) {
                mData = response.body().getDATA();
                initComponent(mData);
            }

            @Override
            public void onFailure(Call<DetailDao> call, Throwable t) {
                Toast.makeText(context, "Error, Check Your Connection!", Toast.LENGTH_SHORT).show();
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
        observableDetail.setNama(mData.getNama());

        if(!mData.getDiskon().equalsIgnoreCase("0")){
            observableDetail.setPrice("Rp "+toRupiahFormat(mData.getHarga()));
            double total = (Double.parseDouble(mData.getHarga()) * Double.parseDouble(mData.getDiskon())) / 100;

            int hasil = Integer.parseInt(mData.getHarga()) -  (int) total;

            observableDetail.setPricedisc("Rp "+toRupiahFormat(String.valueOf(hasil)));

        }else {
            observableDetail.setPrice("Rp "+toRupiahFormat(mData.getHarga()));
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



    public void onCollapsing(View v){
        switch (v.getId()){
            case R.id.btn_spec :
                if(isGoneSpec.get()){
                    isGoneSpec.set(false);
                }else {
                    isGoneSpec.set(true);
                }
                break;
            case R.id.btn_size :
                if(isGoneSize.get()){
                    isGoneSize.set(false);
                }else {
                    isGoneSize.set(true);
                }
                break;
            case R.id.btn_desc :
                if(isGoneDesc.get()){
                    isGoneDesc.set(false);
                }else {
                    isGoneDesc.set(true);
                }
                break;
        }
    }

    @BindingAdapter({"setCollapsing"})
    public static void setCollapsing(TextView textView,boolean b){
        if(b){
            textView.setVisibility(View.GONE);
        }else {
            textView.setVisibility(View.VISIBLE);
        }
    }
    @BindingAdapter({"setStrikeThrough"})
    public static void setStrikeThrough(TextView textView,String discount){
        if(discount.equalsIgnoreCase("")||discount.equalsIgnoreCase("0")){
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }else {
            textView.setPaintFlags(0);
        }
    }

    public String toRupiahFormat(String nominal) {
        NumberFormat rupiahFormat = null;
        String rupiah = "";

        rupiahFormat = NumberFormat.getInstance(Locale.GERMANY);
        rupiah = rupiahFormat.format(Double.parseDouble(nominal)) +",00";


        return rupiah;
    }


    /*
    @BindingAdapter({"setVisibilityDisc"})
    public static void setVisibilityDisc(TextView textView,String discount){
        if(discount.equalsIgnoreCase("")||discount.equalsIgnoreCase("0")){
            textView.setVisibility(View.GONE);
        }else {
            textView.setVisibility(View.VISIBLE);
        }
    }*/
}
