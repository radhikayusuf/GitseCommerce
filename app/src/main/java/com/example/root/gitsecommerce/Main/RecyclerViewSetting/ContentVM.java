package com.example.root.gitsecommerce.Main.RecyclerViewSetting;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;

import com.example.Dao.ContentDao;
import com.example.Dao.ListDao;
import com.example.root.gitsecommerce.databinding.CardContentRowBinding;

import id.gits.mvvmcore.viewmodel.GitsRowVM;
import rx.Observable;

/**
 * Created by root on 07/10/16.
 */

public class ContentVM extends GitsRowVM<ContentDao.ListProduct, CardContentRowBinding> {
    public ObservableField<String> bNameProduct = new ObservableField<>();
    public ObservableField<String> bDiscProduct = new ObservableField<>();
    public ObservableField<String> bPriceProduct = new ObservableField<>();
    public ObservableField<String> bImageProduct = new ObservableField<>();

    public ContentVM(AppCompatActivity activity, CardContentRowBinding binding, ContentDao.ListProduct item) {
        super(activity, binding, item);
        bNameProduct.set(item.nama);
        bDiscProduct.set(item.diskon);
        bPriceProduct.set(item.harga);
        bImageProduct.set(item.url_foto);

    }


}
