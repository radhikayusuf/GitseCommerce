package com.example.Core;

import com.example.Dao.BaseApiDao;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.xml.ws.http.HTTPException;

import okhttp3.ResponseBody;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Observer;

/**
 * Created by Varokah on 10/7/2016.
 */

public abstract class MyObserver<T extends BaseApiDao> implements Observer<T> {
    public abstract void onApiResultCompleted();
    public abstract void onApiResultError(String message,int code);
    public abstract void onApiResultOk(T t);

    @Override
    public final void onCompleted(){
        onApiResultCompleted();
    }

    @Override
    public final void onError(Throwable e){
        if(e instanceof HTTPException){
            try{
                ResponseBody body = ((HttpException) e).response().errorBody();
                BaseApiDao apiDao = new Gson().fromJson(body.string(), BaseApiDao.class);
                onApiResultError(apiDao.message.PROD, apiDao.STATUS_CODE);
            } catch (IOException e1) {
                e1.printStackTrace();
                onApiResultError("Terjadi kesalahan, ", 0);
            }
            onApiResultCompleted();
        }else if (e instanceof UnknownHostException) {
            onApiResultError("Koneksi terputus, silahkan coba lagi", 0);
        } else if (e instanceof SocketTimeoutException) {
            onApiResultError("Koneksi terputus, silahkan coba lagi",0);
        } else {
            System.err.println(e.getMessage());
            e.printStackTrace();
            onApiResultError("Terjadi kesalahan, ", 0);
        }
    }
    @Override
    public final void onNext(T t){
        if (t.STATUS_CODE != 0 && t.STATUS_CODE > 0) {
            onApiResultError(t.message.PROD, 0);
        } else {
            onApiResultOk(t);

        }
    }
}
