package com.example.rodrigo.examenml.util;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rodrigo on 21/01/18.
 */

public class MLHttpInterceptor implements Interceptor {


    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .url(request.url().toString() + "?public_key=" + CoreConfig.getInstance().getApiKey())
                .build();
        Response response = chain.proceed(request);
        return response;
    }



}
