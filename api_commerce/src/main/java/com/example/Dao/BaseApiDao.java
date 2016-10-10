package com.example.Dao;

/**
 * Created by Varokah on 10/7/2016.
 */

public class BaseApiDao {
    private SummaryDao summaryDao;

    private String code;
    private String fields;
    private String message;

    public String getCode() {
        if (summaryDao != null){
            return summaryDao.getCode();
        }else {
            return code;
        }
    }

    public String getFields() {
        return (summaryDao != null)?summaryDao.getFields():fields;
    }

    public String getMessage() {
        if (message != null){
            return message;
        }else if (summaryDao != null){
            return summaryDao.getMessage();
        }
        return null;
    }
}
