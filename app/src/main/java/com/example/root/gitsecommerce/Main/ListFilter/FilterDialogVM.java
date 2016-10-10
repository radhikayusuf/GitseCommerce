package com.example.root.gitsecommerce.Main.ListFilter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.Nullable;
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


    public FilterDialogVM(final Context ctx, @Nullable final Dialog dialog) {

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        };
    }
}
