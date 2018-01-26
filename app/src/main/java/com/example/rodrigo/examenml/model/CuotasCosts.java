package com.example.rodrigo.examenml.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by L0663298 on 26/01/2018.
 */

public class CuotasCosts {

    @SerializedName("recommended_message")
    private String cuotasValue;

    public String getCuotasValue() {
        return cuotasValue;
    }

    public void setCuotasValue(String cuotasValue) {
        this.cuotasValue = cuotasValue;
    }
}
