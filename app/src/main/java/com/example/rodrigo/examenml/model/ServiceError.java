package com.example.rodrigo.examenml.model;

/**
 * Created by rodrigo on 20/01/18.
 */

public class ServiceError {

    private String title;
    private String message;

    public static ServiceError errorDefault() {
        ServiceError error = new ServiceError();
        error.setTitle("Error");
        error.setMessage("Algo ha ocurrido, por favor vuelta a intentar.");
        return error;
    }

    public static ServiceError errorFromTitleAndMessage(String title, String message) {
        ServiceError error = new ServiceError();
        error.setTitle(title);
        error.setMessage(message);
        return error;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
