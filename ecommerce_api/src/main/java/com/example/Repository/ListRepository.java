package com.example.Repository;

import com.example.Core.eCommerceApi;
import com.example.Dao.BaseApiDao;
import com.example.Dao.ContentDao;
import com.example.Dao.ListDao;

import java.util.List;

import rx.Observable;

/**
 * Created by Aqiel on 10/7/2016.
 */

public class ListRepository {
    eCommerceApi meCommerceApi;
    public ListRepository(eCommerceApi commerceApi){
        meCommerceApi = commerceApi;
    }
    public Observable<BaseApiDao<ContentDao>> getContentDao(){
        return meCommerceApi.getApiService().getContentDao();
    }
}
