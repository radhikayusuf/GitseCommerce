package com.example.root.gitsecommerce.Main.RecyclerViewSetting;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.Dao.ListDao;
import com.example.root.gitsecommerce.databinding.CardContentRowBinding;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.Locale;

import id.gits.mvvmcore.viewmodel.GitsRowVM;
import rx.Observable;

/**
 * Created by root on 07/10/16.
 */

public class ContentVM extends GitsRowVM<ListDao.DATABean.ProductsBean, CardContentRowBinding> {
    public ObservableField<String> bNameProduct = new ObservableField<>();
    public ObservableField<String> bDiscProduct = new ObservableField<>();
    public ObservableField<String> bPriceProduct = new ObservableField<>();
    public ObservableField<String> bImageProduct = new ObservableField<>();
    public static Context ctx;

    public ContentVM(AppCompatActivity activity, CardContentRowBinding binding, ListDao.DATABean.ProductsBean item) {
        super(activity, binding, item);
        bNameProduct.set(item.getNama());
        bDiscProduct.set(item.getDiskon()+"%");
        bPriceProduct.set("Rp. "+toRupiahFormat(item.getHarga()));
        bImageProduct.set(item.getUrl_foto());
        ctx = activity.getApplicationContext();
    }

    @BindingAdapter({"setBackground"})
    public static void setBackground(ImageView iv, String url){
        Picasso.with(ctx)
                .load(url)
                .into(iv);
    }

    public String toRupiahFormat(String nominal) {
        NumberFormat rupiahFormat = null;
        String rupiah = "";

        rupiahFormat = NumberFormat.getInstance(Locale.GERMANY);
        rupiah = rupiahFormat.format(Double.parseDouble(nominal)) +",00";


        return rupiah;
    }

}
