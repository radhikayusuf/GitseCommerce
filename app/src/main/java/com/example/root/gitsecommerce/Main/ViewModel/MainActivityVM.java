package com.example.root.gitsecommerce.Main.ViewModel;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
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
    public static List<ListDao.DATABean.ProductsBean> mBaseData = new ArrayList<>();
    public SwipeRefreshLayout.OnRefreshListener onRefreshListener;
    public static Call<ListDao> daoCall;
    public static Context ctx;
    private static String filter = "Semua";
    static String buffHasil = "Semua";
    List<ListDao.DATABean.FilterBean> filterBeen = new ArrayList<>();


    public MainActivityVM(final Context context) {
        super(context);
        ctx = context;
        swipeRefreshLayout = new SwipeRefreshLayout(mContext);
        gridLayoutManager = new GridLayoutManager(mContext, 2);
        bAdapter = new ContentAdapter(mData);

        mData.clear();

        mData.add(new ListDao.DATABean.ProductsBean("1","3","Jogger Pants","Jeans","100000","20","2","http://morefoods.hol.es/img/rest.png"));
        mData.add(new ListDao.DATABean.ProductsBean("2","5","FoodSpot","Gadget","900000","0","2","http://www.morefoods.hol.es/img/food.png"));
        mData.add(new ListDao.DATABean.ProductsBean("3","2","Jogger Pants","Jeans","10000","10","2","http://morefoods.hol.es/img/rest.png"));


        bAdapter.notifyDataSetChanged();

        mBaseData.addAll(mData);

        daoCall = CommerceApi.service(Constant.BASE_URL).getListDao();
        daoCall.enqueue(new Callback<ListDao>() {
            @Override
            public void onResponse(Call<ListDao> call, Response<ListDao> response) {
                filterBeen.addAll(response.body().getDATA().getFilter());
                filter = "Semua";
                //filterDialogVMs = new FilterDialogVM(mContext);
                mData.clear();
                mData.addAll(response.body().getDATA().getProducts());
                mBaseData = mData;
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
                if(v.getId() == R.id.btnFilter){
                    String a[] = {"Ok","Cancel"};
                    showDialog(mContext, "Filter", a);
                    bAdapter.notifyDataSetChanged();
                }else{
                    String a[] = {"Ok","Cancel"};
                    showDialog(mContext, "Sort", a);
                    bAdapter.notifyDataSetChanged();
                }
            }
        };

    }

    public void showDialog(final Context context, String title, String[] btnText) {
        DialogInterface.OnClickListener clickListenerPos, clickListenerNeg;
        final CharSequence[] items = { "Semua", "Gadget", "Shirt", "Jeans"};
        buffHasil = "";

        clickListenerPos = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                filter = buffHasil;
                Toast.makeText(context, filter, Toast.LENGTH_SHORT).show();
                //mData = onFilterData(filter);
                //mData.remove(0);
                mData.clear();
                mData.addAll(onFilterData(filter,mBaseData));
                bAdapter.notifyDataSetChanged();

                Log.d("Sizenya : ", String.valueOf(mData.size()));
                paramDialogInterface.dismiss();
            }
        };

        clickListenerNeg = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };



        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);

        builder.setSingleChoiceItems(items, -1,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Toast.makeText(context, "Data "+items[item], Toast.LENGTH_SHORT).show();
                        buffHasil = String.valueOf(items[item]);
                    }
                });

        builder.setPositiveButton(btnText[0], clickListenerPos);

        if (btnText.length != 1) {
            builder.setNegativeButton(btnText[1], clickListenerNeg);
        }

        builder.show();
    }


    public List<ListDao.DATABean.ProductsBean> onFilterData(String filter, List<ListDao.DATABean.ProductsBean> mData1){
        List<ListDao.DATABean.ProductsBean> mData2 = new ArrayList<>();
        mData2.clear();
        int i;
        switch (filter){
            case "Semua":
                mData2 = mBaseData;
                return mData2;
            case "Gadget":
                for (i=0; i< mData1.size(); i++){
                    if(mData1.get(i).getJenis().equalsIgnoreCase("Gadget")){
                        mData2.add(mData1.get(i));
                    }
                }
                return mData2;
            case "Shirt" :
                for (i=0; i< mData1.size(); i++){
                    if(mData1.get(i).getJenis().equalsIgnoreCase("Shirt")){
                        mData2.add(mData1.get(i));
                    }
                }
                return mData2;
            case "Jeans" :
                for (i=0; i< mData1.size(); i++){
                    if(mData1.get(i).getJenis().equalsIgnoreCase("jeans")){
                        mData2.add(mData1.get(i));
                    }
                }
                return mData2;
        }

        Log.d("DataSize ", String.valueOf(mData2.size()));
        return mData2;
    }

    @BindingAdapter({"onRefresh"})
    public static void onRefresh(final SwipeRefreshLayout swipeRefreshLayout, SwipeRefreshLayout.OnRefreshListener newSwipe){
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                daoCall.clone().enqueue(new Callback<ListDao>() {
                    @Override
                    public void onResponse(Call<ListDao> call, Response<ListDao> response) {
                        filter = "Semua";
                        mData.clear();
                        mData.addAll(response.body().getDATA().getProducts());
                        bAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onFailure(Call<ListDao> call, Throwable t) {
                        Toast.makeText(ctx, "Error, Check Your Connection!", Toast.LENGTH_SHORT).show();
                        swipeRefreshLayout.setRefreshing(false);

                    }
                });
            }
        });

    }

}
