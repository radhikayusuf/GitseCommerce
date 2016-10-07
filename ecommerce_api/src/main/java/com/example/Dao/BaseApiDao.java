package com.example.Dao;

/**
 * Created by Varokah on 10/7/2016.
 */

public class BaseApiDao<T> {


   public boolean STATUS;
   public int STATUS_CODE;
   public MESSAGE message;
    public T DATA;


    public class MESSAGE {
        public String PROD;
        public String DEVEL;

    }
}
