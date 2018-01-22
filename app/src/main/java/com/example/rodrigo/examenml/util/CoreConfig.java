package com.example.rodrigo.examenml.util;

/**
 * Created by rodrigo on 21/01/18.
 */

public class CoreConfig {

    private static CoreConfig instance;

    private String apiKey;


    private CoreConfig() {}

    public static CoreConfig getInstance() {
        if(instance == null) {
            instance = new CoreConfig();
        }
        return instance;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }


}
