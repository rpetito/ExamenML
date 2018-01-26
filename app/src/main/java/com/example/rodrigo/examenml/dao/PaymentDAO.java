package com.example.rodrigo.examenml.dao;

import com.example.rodrigo.examenml.model.PaymentMethod;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rodrigo on 21/01/18.
 */

public class PaymentDAO extends BaseDAO {


    public void getPaymentMethods() {
        doServiceCall(getRetrofit().create(PaymentREST.class).getPaymentMethods());
    }


    public void getBanks(String paymentMethod) {
        doServiceCall(getRetrofit().create(PaymentREST.class).getBanks(paymentMethod));
    }


    private interface PaymentREST {
        @GET("payment_methods")
        Call<List<PaymentMethod>> getPaymentMethods();
        @GET("payment_methods/card_issuers")
        Call<List<PaymentMethod>> getBanks(@Query("payment_method_id") String paymentMethod);
    }


}
