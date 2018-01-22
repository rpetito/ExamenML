package com.example.rodrigo.examenml.util;

import android.app.Application;

/**
 * Created by rodrigo on 21/01/18.
 */

public class MLApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CoreConfig.getInstance().setApiKey("444a9ef5-8a6b-429f-abdf-587639155d88");
    }


}
