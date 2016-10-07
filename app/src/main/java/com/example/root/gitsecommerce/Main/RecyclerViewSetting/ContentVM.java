package com.example.root.gitsecommerce.Main.RecyclerViewSetting;

import android.content.Context;

import com.example.root.gitsecommerce.databinding.CardContentRowBinding;

import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by root on 07/10/16.
 */

public class ContentVM extends GitsRowVM<ContentVM, CardContentRowBinding> {

    public ContentVM(Context context, CardContentRowBinding binding, ContentVM data) {
        super(context, binding, data);
    }
}
