package com.example.root.gitsecommerce.Detail;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.root.gitsecommerce.BR;

/**
 * Created by root on 09/10/16.
 */

public class ObservableDetail extends BaseObservable {
    public String nama, rating, desc, spec;

    public ObservableDetail(String nama, String rating, String desc, String spec) {
        this.nama = nama;
        this.rating = rating;
        this.desc = desc;
        this.spec = spec;
    }

    @Bindable
    public String getName() {
        return nama;
    }

    public void setName(String nama) {
        this.nama = nama;
        //notifyPropertyChanged(BR.); <= qiel yang ini gabisa bisa
    }


   @Bindable
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
        //notifyPropertyChanged(BR.);
    }


    @Bindable
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
     //   notifyPropertyChanged(BR.desc);
    }

    @Bindable
    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
//        notifyPropertyChanged(BR.spec);
    }
}
