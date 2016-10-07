package com.example;

import com.example.Dao.ListDao;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Varokah on 10/7/2016.
 */

public interface ApiService {
    @GET("list")
    Observable<ListDao> getListDao();

}
