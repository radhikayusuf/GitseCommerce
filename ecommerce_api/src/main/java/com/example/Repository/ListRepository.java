package com.example.Repository;

import com.example.Core.eCommerceApi;
import com.example.Dao.ListDao;

import rx.Observable;

/**
 * Created by Aqiel on 10/7/2016.
 *
 */

public class ListRepository {
    eCommerceApi meCommerceApi;
    public ListRepository(eCommerceApi commerceApi){
        meCommerceApi = commerceApi;
    }
    public Observable<ListDao> getListDao(){
        return meCommerceApi.getApiService().getListDao();
    }
}
