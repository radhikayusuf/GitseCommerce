package com.example;

import com.example.Dao.DetailDao;
import com.example.Dao.ListDao;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Aqiel on 10/7/2016.
 */

public interface ApiService {
    @GET("list")
    Observable<ListDao> getListDao();

    @GET("list/{id}")
    Observable<DetailDao> getDetail(@Path("id") String id);
}
