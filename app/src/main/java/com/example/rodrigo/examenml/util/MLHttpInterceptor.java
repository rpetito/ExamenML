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
                .url(addPublicKey(request.url().toString()))
                .build();
        Response response = chain.proceed(request);
        return response;
    }


    private String addPublicKey(String url) {

        String finalURL;

        String[] urlSplit = url.split("/");
        String lastPart = urlSplit[urlSplit.length - 1];
        if(hasParams(lastPart)) {
            finalURL = url + "&public_key=" + CoreConfig.getInstance().getApiKey();
        } else {
            finalURL = url + "?public_key=" + CoreConfig.getInstance().getApiKey();
        }

        return finalURL;
    }


    private boolean hasParams(String url) {
        return url.contains("?");
    }
}
