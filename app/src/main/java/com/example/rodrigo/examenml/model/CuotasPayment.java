package com.example.rodrigo.examenml.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by L0663298 on 26/01/2018.
 */

public class CuotasPayment {

    @SerializedName("payer_costs")
    private List<CuotasCosts> costsList;


    public List<CuotasCosts> getCostsList() {
        return costsList;
    }

    public void setCostsList(List<CuotasCosts> costsList) {
        this.costsList = costsList;
    }
}
