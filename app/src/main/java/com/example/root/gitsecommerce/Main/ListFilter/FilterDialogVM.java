package com.example.root.gitsecommerce.Main.ListFilter;

import android.content.Context;
import android.util.Log;

import com.example.Dao.ListDao;
import com.example.root.gitsecommerce.Main.ViewModel.MainActivityVM;

import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by Varokah on 10/7/2016.
 */

public class FilterDialogVM{
    public String semua, gadget, shirt, jeans;

    public FilterDialogVM(Context ctx, List<ListDao.DATABean.FilterBean> filterBeen) {
        gadget = filterBeen.get(0).getJenis();
        shirt = filterBeen.get(1).getJenis();
        jeans = filterBeen.get(2).getJenis();
    }
}
