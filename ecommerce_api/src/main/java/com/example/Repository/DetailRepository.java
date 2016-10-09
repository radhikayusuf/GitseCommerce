package com.example.Repository;

import com.example.Core.eCommerceApi;
import com.example.Dao.DetailDao;

import rx.Observable;

/**
 * Created by root on 09/10/16.
 */

public class DetailRepository {
    eCommerceApi meCommerceApi;
    public DetailRepository(eCommerceApi commerceApi){
        meCommerceApi = commerceApi;
    }
    public Observable<DetailDao> getDetailDao(String id){
        return meCommerceApi.getApiService().getDetail(id);
    }
}
