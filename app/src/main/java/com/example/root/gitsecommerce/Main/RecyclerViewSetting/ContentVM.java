package com.example.root.gitsecommerce.Main.RecyclerViewSetting;

import android.content.Context;
import android.databinding.ObservableField;

import com.example.Dao.ListDao;
import com.example.root.gitsecommerce.databinding.CardContentRowBinding;

import id.gits.mvvmcore.viewmodel.GitsRowVM;
import rx.Observable;

/**
 * Created by root on 07/10/16.
 */

public class ContentVM extends GitsRowVM<ListDao, CardContentRowBinding> {
    public ObservableField<String> bNameProduct = new ObservableField<>();
    public ObservableField<String> bDiscProduct = new ObservableField<>();
    public ObservableField<String> bPriceProduct = new ObservableField<>();
    public ObservableField<String> bImageProduct = new ObservableField<>();
    public ContentVM(Context context, CardContentRowBinding binding, ListDao data) {
        super(context, binding, data);

    }
}
