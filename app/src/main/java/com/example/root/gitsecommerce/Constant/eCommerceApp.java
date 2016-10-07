package com.example.root.gitsecommerce.Constant;

import android.app.Application;

import com.example.Core.eCommerceApi;

/**
 * Created by Varokah on 10/7/2016.
 */

public class eCommerceApp extends Application{
    private static eCommerceApi meCommerceApi;

    public static eCommerceApi getMeCommerceApi() {
        if(meCommerceApi == null){
            meCommerceApi = new eCommerceApi(Constant.BASE_URL);
        }
        return meCommerceApi;
    }
}
