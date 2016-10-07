package com.example.Dao;

import java.util.List;

/**
 * Created by Varokah on 10/7/2016.
 */

public class ListDao {

    /**
     * STATUS : true
     * STATUS_CODE : 200
     * MESSAGE : {"PROD":"Data found","DEVEL":"Data found"}
     * DATA : {"filter":[{"jenis":"Gadget"},{"jenis":"Shirt"},{"jenis":"jeans"}],"products":[{"id":"1","rating":"2","nama":"Polo shirt","jenis":"Shirt","harga":"150000","diskon":"0","stok":"15","url_foto":"http://dev.gits.co.id/apiecommerce/public/assets/polo-shirt.jpg"},{"id":"2","rating":"4","nama":"Macbook pro","jenis":"Gadget","harga":"13000000","diskon":"10","stok":"5","url_foto":"http://dev.gits.co.id/apiecommerce/public/assets/macbook-pro.jpg"},{"id":"5","rating":"5","nama":"Peter Says Denim - original","jenis":"jeans","harga":"400000","diskon":"10","stok":"13","url_foto":"psd-jeans.jpg"},{"id":"6","rating":"3","nama":"iPad Leather Case","jenis":"Gadget","harga":"250000","diskon":"0","stok":"30","url_foto":"Ipad-leather.jpg"}]}
     */

    private boolean STATUS;
    private int STATUS_CODE;
    /**
     * PROD : Data found
     * DEVEL : Data found
     */

    private MESSAGEBean MESSAGE;
    private DATABean DATA;

    public boolean isSTATUS() {
        return STATUS;
    }

    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }

    public int getSTATUS_CODE() {
        return STATUS_CODE;
    }

    public void setSTATUS_CODE(int STATUS_CODE) {
        this.STATUS_CODE = STATUS_CODE;
    }

    public MESSAGEBean getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(MESSAGEBean MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public DATABean getDATA() {
        return DATA;
    }

    public void setDATA(DATABean DATA) {
        this.DATA = DATA;
    }

    public static class MESSAGEBean {
        private String PROD;
        private String DEVEL;

        public String getPROD() {
            return PROD;
        }

        public void setPROD(String PROD) {
            this.PROD = PROD;
        }

        public String getDEVEL() {
            return DEVEL;
        }

        public void setDEVEL(String DEVEL) {
            this.DEVEL = DEVEL;
        }
    }

    public static class DATABean {
        /**
         * jenis : Gadget
         */

        private List<FilterBean> filter;
        /**
         * id : 1
         * rating : 2
         * nama : Polo shirt
         * jenis : Shirt
         * harga : 150000
         * diskon : 0
         * stok : 15
         * url_foto : http://dev.gits.co.id/apiecommerce/public/assets/polo-shirt.jpg
         */

        private List<ProductsBean> products;

        public List<FilterBean> getFilter() {
            return filter;
        }

        public void setFilter(List<FilterBean> filter) {
            this.filter = filter;
        }

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class FilterBean {
            private String jenis;

            public String getJenis() {
                return jenis;
            }

            public void setJenis(String jenis) {
                this.jenis = jenis;
            }
        }

        public static class ProductsBean {
            private String id;
            private String rating;
            private String nama;
            private String jenis;
            private String harga;
            private String diskon;
            private String stok;
            private String url_foto;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }

            public String getNama() {
                return nama;
            }

            public void setNama(String nama) {
                this.nama = nama;
            }

            public String getJenis() {
                return jenis;
            }

            public void setJenis(String jenis) {
                this.jenis = jenis;
            }

            public String getHarga() {
                return harga;
            }

            public void setHarga(String harga) {
                this.harga = harga;
            }

            public String getDiskon() {
                return diskon;
            }

            public void setDiskon(String diskon) {
                this.diskon = diskon;
            }

            public String getStok() {
                return stok;
            }

            public void setStok(String stok) {
                this.stok = stok;
            }

            public String getUrl_foto() {
                return url_foto;
            }

            public void setUrl_foto(String url_foto) {
                this.url_foto = url_foto;
            }
        }
    }
}
