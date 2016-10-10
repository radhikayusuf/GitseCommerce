package com.example.root.gitsecommerce.Detail;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.root.gitsecommerce.BR;

/**
 * Created by root on 09/10/16.
 */

public class ObservableDetail extends BaseObservable {
    public String nama, desc, spec,price,size,imageurl,stok,discount,pricedisc;
    public float rating;

    //constructor
    public ObservableDetail(String nama, String desc, String spec, String price, String size, String imageurl, String stok, String discount, String pricedisc, float rating) {
        this.nama = nama;
        this.desc = desc;
        this.spec = spec;
        this.price = price;
        this.size = size;
        this.imageurl = imageurl;
        this.stok = stok;
        this.discount = discount;
        this.pricedisc = pricedisc;
        this.rating = rating;
    }

    //getter
    @Bindable
    public String getNama() {
        return nama;
    }
    @Bindable
    public String getDesc() {
        return desc;
    }
    @Bindable
    public String getSpec() {
        return spec;
    }
    @Bindable
    public String getPrice() {
        return price;
    }
    @Bindable
    public String getSize() {
        return size;
    }
    @Bindable
    public String getImageurl() {
        return imageurl;
    }
    @Bindable
    public String getStok() {
        return stok;
    }
    @Bindable
    public String getDiscount() {
        return discount;
    }
    @Bindable
    public String getPricedisc() {
        return pricedisc;
    }
    @Bindable
    public float getRating() {
        return rating;
    }
    //setter
    public void setNama(String nama) {
        this.nama = nama;
        notifyPropertyChanged(BR.nama);
    }

    public void setDesc(String desc) {
        this.desc = desc;
        notifyPropertyChanged(BR.desc);
    }

    public void setSpec(String spec) {
        this.spec = spec;
        notifyPropertyChanged(BR.spec);
    }

    public void setPrice(String price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }

    public void setSize(String size) {
        this.size = size;
        notifyPropertyChanged(BR.size);
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
        notifyPropertyChanged(BR.imageurl);
    }

    public void setStok(String stok) {
        this.stok = stok;
        notifyPropertyChanged(BR.stok);
    }

    public void setDiscount(String discount) {
        this.discount = discount;
        notifyPropertyChanged(BR.discount);
    }

    public void setPricedisc(String pricedisc) {
        this.pricedisc = pricedisc;
        notifyPropertyChanged(BR.pricedisc);
    }

    public void setRating(float rating) {
        this.rating = rating;
        notifyPropertyChanged(BR.rating);
    }
}
