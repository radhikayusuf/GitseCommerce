package com.example;

import com.example.Dao.DetailDao;
import com.example.Dao.ListDao;

import jdk.nashorn.internal.objects.annotations.Getter;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by root on 10/10/16.
 */

public interface CommerceListener {
    @GET("list")
    Call<ListDao> getListDao();

    @GET("list/{id}")
    Call<DetailDao> getDetail(@Path("id") String id);
}
