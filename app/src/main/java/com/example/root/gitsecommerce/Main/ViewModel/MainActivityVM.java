package com.example.root.gitsecommerce.Main.ViewModel;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

import com.example.Core.MyObserver;
import com.example.Dao.BaseApiDao;
import com.example.Dao.ContentDao;
import com.example.Repository.ListRepository;
import com.example.root.gitsecommerce.Constant.eCommerceApp;
import com.example.root.gitsecommerce.Main.RecyclerViewSetting.ContentAdapter;

import java.util.ArrayList;
import java.util.List;
import android.os.Handler;

import id.gits.mvvmcore.viewmodel.GitsVM;
import rx.schedulers.Schedulers;

/**
 * Created by root on 07/10/16.
 */

public class MainActivityVM extends GitsVM {
    public ContentAdapter bAdapter;
    public GridLayoutManager gridLayoutManager;
    private ListRepository mListRepository;
//    public List<ListDao.DATABean.ProductsBean> mData = new ArrayList<>();
    public List<ContentDao.ListProduct> mData = new ArrayList<>();
    Handler handler = new Handler();

    public MainActivityVM(Context context) {
        super(context);
        mListRepository = new ListRepository(eCommerceApp.getMeCommerceApi());
        gridLayoutManager = new GridLayoutManager(mContext, 2);
//        bAdapter = new ContentAdapter(mData);
        getCommerceList();
    }

    void getCommerceList(){
        addSubscription(mListRepository.getContentDao()
        .subscribeOn(Schedulers.io())
        .subscribe(new MyObserver<BaseApiDao<ContentDao>>(){

            @Override
            public void onApiResultCompleted() {
            }

            @Override
            public void onApiResultError(String message, int code) {

            }

            @Override
            public void onApiResultOk(BaseApiDao<ContentDao> contentDaoBaseApiDao) {
               mData.addAll(contentDaoBaseApiDao.DATA.products);
                initRecycleView(mData);
            }

//            @Override
//            public void onApiResultOk(ContentDao.ListProduct listProduct) {
//                mData.add(listProduct);
//                initRecycleView(mData);
//
//            }
/*

            @Override
            public void onApiResultOk(ContentDao contentDao) {
                //Log.wtf("DATA",listDao.getDATA().getProducts().get(0).getNama());
             }
*/
        }));
    }

    private void initRecycleView(List<ContentDao.ListProduct> mData) {
            bAdapter = new ContentAdapter((ContentDao.ListProduct) mData);
            bAdapter.notifyDataSetChanged();
    }



}
