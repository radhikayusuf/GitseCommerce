package com.example.Dao;

import java.util.List;

/**
 * Created by root on 09/10/16.
 */

public class DetailDao extends BaseApiDao {

    /**
     * STATUS : true
     * STATUS_CODE : 200
     * MESSAGE : {"PROD":"Data Found","DEVEL":"Data Found"}
     * DATA : {"nama":"Polo shirt","harga":"150000","diskon":"0","deskripsi":"Polo shirt berbahan katun dengan tenunan terbaik","spesifikasi":null,"ukuran":[{"available":"XL"},{"available":"L"},{"available":"M"},{"available":"S"},{"available":"XS"}]}
     */

    private boolean STATUS;
    private int STATUS_CODE;
    /**
     * PROD : Data Found
     * DEVEL : Data Found
     */

    private MESSAGEBean MESSAGE;
    /**
     * nama : Polo shirt
     * harga : 150000
     * diskon : 0
     * deskripsi : Polo shirt berbahan katun dengan tenunan terbaik
     * spesifikasi : null
     * ukuran : [{"available":"XL"},{"available":"L"},{"available":"M"},{"available":"S"},{"available":"XS"}]
     */

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
        private String nama;
        private String harga;
        private String diskon;
        private String deskripsi;
        private String spesifikasi;
        /**
         * available : XL
         */

        private List<UkuranBean> ukuran;

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
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

        public String getDeskripsi() {
            return deskripsi;
        }

        public void setDeskripsi(String deskripsi) {
            this.deskripsi = deskripsi;
        }

        public String getSpesifikasi() {
            return spesifikasi;
        }

        public void setSpesifikasi(String spesifikasi) {
            this.spesifikasi = spesifikasi;
        }

        public List<UkuranBean> getUkuran() {
            return ukuran;
        }

        public void setUkuran(List<UkuranBean> ukuran) {
            this.ukuran = ukuran;
        }

        public static class UkuranBean {
            private String available;

            public String getAvailable() {
                return available;
            }

            public void setAvailable(String available) {
                this.available = available;
            }
        }
    }
}
