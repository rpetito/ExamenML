package com.example.rodrigo.examenml.controller;

import com.example.rodrigo.examenml.dao.BaseDAO;

/**
 * Created by rodrigo on 20/01/18.
 */

public class BaseController<T extends BaseDAO> {

    private T dao;

    public BaseController(T dao) {
        this.dao = dao;
    }

    public T getDao() {
        return dao;
    }


    public void onPause() {
        if(dao != null) {
            dao.cancelCallRequest();
        }
    }

    public void onResume() {
        if(dao != null) {
            dao.setCanReturn(true);
        }
    }

}
