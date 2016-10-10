package com.example.root.gitsecommerce.Main.ViewModel;

import android.app.Dialog;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;

//import com.example.Core.MyObserver;
import com.example.Core.CommerceApi;
import com.example.Dao.ListDao;
//import com.example.Repository.ListRepository;
import com.example.root.gitsecommerce.Constant.Constant;
import com.example.root.gitsecommerce.Main.ListFilter.FilterDialogVM;
import com.example.root.gitsecommerce.Main.ListShort.ShortDialog;
import com.example.root.gitsecommerce.Main.ListShort.ShortDialogVM;
import com.example.root.gitsecommerce.Main.RecyclerViewSetting.ContentAdapter;
import com.example.root.gitsecommerce.R;
import com.example.root.gitsecommerce.databinding.FilterDialogBinding;
import com.example.root.gitsecommerce.databinding.ShortDialogBinding;
import com.google.common.collect.SortedMapDifference;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import id.gits.mvvmcore.viewmodel.GitsVM;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by root on 07/10/16.
 */

public class MainActivityVM extends GitsVM {
    public static ContentAdapter bAdapter;
    public SwipeRefreshLayout swipeRefreshLayout;
    public GridLayoutManager gridLayoutManager;
    public Button.OnClickListener btn, btnBack;
    public static List<ListDao.DATABean.ProductsBean> mData = new ArrayList<>();
    public SwipeRefreshLayout.OnRefreshListener onRefreshListener;
    public static Call<ListDao> daoCall;
    public static Context ctx;
    private static String hasil = "Gagal";
    FilterDialogVM filterDialogVMs;
    List<ListDao.DATABean.FilterBean> filterBeen = new ArrayList<>();
    FilterDialogBinding filterDialogBinding;


    public MainActivityVM(final Context context) {
        super(context);
        ctx = context;
        swipeRefreshLayout = new SwipeRefreshLayout(mContext);
        gridLayoutManager = new GridLayoutManager(mContext, 2);
        bAdapter = new ContentAdapter(mData);

        mData.clear();
        mData.add(new ListDao.DATABean.ProductsBean("1","5","Jogger Pants","Jeans","100000","0","2","http://morefoods.hol.es/img/rest.png"));

        // v Delete soon!  v //

        //filterDialogVMs = new FilterDialogVM(mContext, null);

        // ^ Delete soon!  ^ //

        daoCall = CommerceApi.service(Constant.BASE_URL).getListDao();
        daoCall.enqueue(new Callback<ListDao>() {
            @Override
            public void onResponse(Call<ListDao> call, Response<ListDao> response) {
                filterBeen.addAll(response.body().getDATA().getFilter());
                //filterDialogVMs = new FilterDialogVM(mContext);
                mData.clear();
                mData.addAll(response.body().getDATA().getProducts());
                bAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ListDao> call, Throwable t) {
                Toast.makeText(mContext, "Error, Check Your Connection!", Toast.LENGTH_SHORT).show();
                Log.d("GET Content ","Failed "+t.getMessage());
            }
        });

        btn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);

                if(v.getId() == R.id.btnFilter){
                    dialog.setTitle("Filter");
                    FilterDialogBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context)
                    ,R.layout.filter_dialog, null, false);
                    binding.setVm(new FilterDialogVM(mContext, dialog));
                    dialog.setContentView(binding.getRoot());
                }else{
                    dialog.setTitle("Sort");
                    ShortDialogBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context)
                    ,R.layout.short_dialog, null, false);
                    binding.setVm(new ShortDialogVM(mContext, dialog));
                    dialog.setContentView(binding.getRoot());
                }

                dialog.setCancelable(true);
                dialog.show();

//                AlertDialog.Builder builder = new  AlertDialog.Builder(context);
//
//                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(mContext,"OK",Toast.LENGTH_SHORT).show();
//                         dialog.dismiss();
//                    }
//                });
//
//                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//                AlertDialog dialog = builder.create();
//                dialog.show();
            }
        };

    }

    @BindingAdapter({"onRefresh"})
    public static void onRefresh(final SwipeRefreshLayout swipeRefreshLayout, SwipeRefreshLayout.OnRefreshListener newSwipe){
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                daoCall.clone().enqueue(new Callback<ListDao>() {
                    @Override
                    public void onResponse(Call<ListDao> call, Response<ListDao> response) {
                        mData.clear();
                        mData.addAll(response.body().getDATA().getProducts());
                        bAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }public String hello = "Hello";

                    @Override
                    public void onFailure(Call<ListDao> call, Throwable t) {
                        Toast.makeText(ctx, "Error, Check Your Connection!", Toast.LENGTH_SHORT).show();
                        swipeRefreshLayout.setRefreshing(false);

                    }
                });
            }
        });

    }

    public void onFilterData(String filter){
        List<ListDao.DATABean.ProductsBean> mData2 = new ArrayList<>();
        mData.clear();
        int i;
        switch (filter){
            case "Semua" :
                mData2 = mData;
                break;
            case "Gadget" :
                for (i=0;i<mData.size();i++){
                    if(mData.get(i).getJenis().equalsIgnoreCase("Gadget")){
                        mData2 = mData;
                    }
                }
                break;
            case "Shirt" :
                for (i=0;i<mData.size();i++){
                    if(mData.get(i).getJenis().equalsIgnoreCase("Shirt")){
                        mData2 = mData;
                    }
                }
                break;
            case "Jeans" :
                for (i=0;i<mData.size();i++){
                    if(mData.get(i).getJenis().equalsIgnoreCase("jeans")){
                        mData2 = mData;
                    }
                }
                break;
        }
        mData = mData2;
        //bAdapter = new ContentAdapter(mData2);
        bAdapter.notifyDataSetChanged();
    }
    //not finished
//    public void onShort(){
//        mData3.clear();
//        switch (shrt){
//            case "popularity" :
//                int i;
//                for(i = 0;i<mData2.size();i++){
//
//                }
//                break;
//            case "lowtohigh" :
//                break;
//            case "hightolow" :
//                break;
//        }
//        bAdapter = new ContentAdapter(mData3);
//        bAdapter.notifyDataSetChanged();
//    }

}
