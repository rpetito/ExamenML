package com.example.rodrigo.examenml.controller;

import com.example.rodrigo.examenml.dao.PaymentDAO;
import com.example.rodrigo.examenml.model.PaymentMethod;
import com.example.rodrigo.examenml.model.PaymentSelection;
import com.example.rodrigo.examenml.model.ServiceError;
import com.example.rodrigo.examenml.util.ResponseListener;

import java.util.List;

/**
 * Created by rodrigo on 21/01/18.
 */

public class PaymentController extends BaseController<PaymentDAO> {


    public PaymentController() {
        super(new PaymentDAO());
    }

    public void getPaymentMethods(final ResponseListener<List<PaymentMethod>> listener) {

        getDao().setResponseListener(new ResponseListener<List<PaymentMethod>>() {
            @Override
            public void onSuccess(List<PaymentMethod> item) {
                listener.onSuccess(item);
            }

            @Override
            public void onError(ServiceError error) {
                listener.onError(error);
            }
        });

        getDao().getPaymentMethods();

    }

    public void getBanks(final ResponseListener<List<PaymentMethod>> listener) {

        getDao().setResponseListener(new ResponseListener<List<PaymentMethod>>() {
            @Override
            public void onSuccess(List<PaymentMethod> item) {
                listener.onSuccess(item);
            }

            @Override
            public void onError(ServiceError error) {
                listener.onError(error);
            }
        });

        getDao().getBanks(PaymentSelection.getInstance().getPaymentMethod().getId());

    }

}
