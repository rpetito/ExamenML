package com.example.rodrigo.examenml.util;

import com.example.rodrigo.examenml.model.ServiceError;

/**
 * Created by rodrigo on 20/01/18.
 */

public interface ResponseListener<T> {

    void onSuccess(T item);
    void onError(ServiceError error);
}
