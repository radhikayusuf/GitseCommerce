package com.example.Dao;

import java.util.List;

/**
 * Created by Varokah on 10/7/2016.
 */

public class ContentDao extends BaseApiDao {
    public List<ListFilter> filters;
    public List<ListProduct> products;

    public class ListFilter {
        public String filter;
    }


    public class ListProduct {
        public String id;
        public String rating;
        public String nama;
        public String jenis;
        public String harga;
        public String diskon;
        public String stok;
        public String url_foto;

    }
}
