package com.example.rodrigo.examenml.dao;

import com.example.rodrigo.examenml.BuildConfig;
import com.example.rodrigo.examenml.model.ServiceError;
import com.example.rodrigo.examenml.util.MLHttpInterceptor;
import com.example.rodrigo.examenml.util.ResponseListener;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rodrigo on 20/01/18.
 */

public class BaseDAO implements Callback {

    private ResponseListener responseListener;
    private boolean canReturn;
    private Retrofit retrofit;
    private Call serviceCall;


    public BaseDAO() {
        this.canReturn = true;
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createHttpClient())
                .build();
    }


    private OkHttpClient createHttpClient() {
        return new OkHttpClient().newBuilder().addInterceptor(new MLHttpInterceptor()).build();
    }


    protected void doServiceCall(Call serviceCall) {
        this.serviceCall = serviceCall;
        serviceCall.enqueue(this);
    }


    @Override
    public void onResponse(Call call, Response response) {
        try {
            if (canReturn) {
                if (response.isSuccessful()) {
                    responseListener.onSuccess(response.body());
                } else {
                    responseListener.onError(ServiceError.errorDefault());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if(responseListener != null) {
                responseListener.onError(ServiceError.errorDefault());
            } else {
                throw new RuntimeException("ResponseListener null");
            }
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        try {
            if (canReturn) {
                responseListener.onError(ServiceError.errorDefault());
            }
        } catch (Exception e) {
            e.printStackTrace();
            if(responseListener != null) {
                responseListener.onError(ServiceError.errorDefault());
            } else {
                throw new RuntimeException("ResponseListener null");
            }
        }
    }


    public void setResponseListener(ResponseListener responseListener) {
        this.responseListener = responseListener;
    }

    public void setCanReturn(boolean canReturn) {
        this.canReturn = canReturn;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void cancelCallRequest() {
        if(this.serviceCall != null) {
            this.serviceCall.cancel();
        }
    }



}
