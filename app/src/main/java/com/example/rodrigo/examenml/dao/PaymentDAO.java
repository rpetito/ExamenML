package com.example.rodrigo.examenml.dao;

import com.example.rodrigo.examenml.model.PaymentMethod;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rodrigo on 21/01/18.
 */

public class PaymentDAO extends BaseDAO {


    public void getPaymentMethods() {
        doServiceCall(getRetrofit().create(PaymentREST.class).getPaymentMethods());
    }




    private interface PaymentREST {
        @GET("payment_methods")
        Call<List<PaymentMethod>> getPaymentMethods();
    }

}
