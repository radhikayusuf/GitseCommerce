package com.example.root.gitsecommerce.Main.ViewModel;

import android.content.Context;

import com.example.root.gitsecommerce.Constant.eCommerceApp;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by root on 07/10/16.
 */

public class MainActivityVM extends GitsVM {
    public MainActivityVM(Context context) {
        super(context);
        eCommerceApp

    }

    void getCommerceList(){
        addSubscription(eCommerceApp);
    }
}
