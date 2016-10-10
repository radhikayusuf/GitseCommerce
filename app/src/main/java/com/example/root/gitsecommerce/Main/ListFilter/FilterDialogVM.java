package com.example.root.gitsecommerce.Main.ListFilter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.Dao.ListDao;
import com.example.root.gitsecommerce.Main.ViewModel.MainActivityVM;

import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by Varokah on 10/7/2016.
 */

public class FilterDialogVM{
    public String semua = "Semua", gadget ="Gadget", shirt="Shirt", jeans="Jeans";
    public Button.OnClickListener onClickListener;


    public FilterDialogVM(final Context ctx) {

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, "Hello!", Toast.LENGTH_SHORT).show();
            }
        };


//
//        gadget = filterBeen.get(0).getJenis();
//        shirt = filterBeen.get(1).getJenis();
//        jeans = filterBeen.get(2).getJenis();
    }
}
