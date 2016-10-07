package com.example.Core;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Varokah on 10/7/2016.
 */

public class ApiInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request requestUser =  request.newBuilder().build();
        return chain.proceed(requestUser);
    }
}
