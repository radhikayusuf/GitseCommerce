package com.example.Core;

import com.example.CommerceListener;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 10/10/16.
 */

public class CommerceApi {
    public static CommerceListener service(String baseurl){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseurl)
                .build();
        return retrofit.create(CommerceListener.class);
    }
}
