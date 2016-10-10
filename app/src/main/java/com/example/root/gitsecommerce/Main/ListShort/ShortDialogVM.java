package com.example.root.gitsecommerce.Main.ListShort;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import id.gits.mvvmcore.viewmodel.GitsRowVM;
import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by Varokah on 10/7/2016.
 */

public class ShortDialogVM {
    public Button.OnClickListener onClickListener;
    public ShortDialogVM(Context context, final Dialog dialog) {
        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        };
    }
}
