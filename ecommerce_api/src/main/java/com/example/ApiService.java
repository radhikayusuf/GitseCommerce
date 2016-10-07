package com.example;

import com.example.Dao.BaseApiDao;
import com.example.Dao.ContentDao;
import com.example.Dao.ListDao;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Aqiel on 10/7/2016.
 */

public interface ApiService {
    @GET("list")
//    Observable<ListDao> getListDao();
    Observable<BaseApiDao<ContentDao>> getContentDao();

}
