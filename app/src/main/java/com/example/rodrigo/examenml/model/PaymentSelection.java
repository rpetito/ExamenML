package com.example.rodrigo.examenml.model;

import java.math.BigDecimal;

/**
 * Created by L0663298 on 26/01/2018.
 */

public class PaymentSelection {

    private static PaymentSelection instance;

    private BigDecimal ammount;
    private PaymentMethod paymentMethod;
    private PaymentMethod bank;
    private CuotasCosts cuotas;


    private PaymentSelection() {

    }


    public static PaymentSelection getInstance() {
        if(instance == null) {
            instance = new PaymentSelection();
        }
        return instance;
    }



    public BigDecimal getAmmount() {
        return ammount;
    }

    public void setAmmount(String ammount) {
        this.ammount = new BigDecimal(ammount);
    }


    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getBank() {
        return bank;
    }

    public void setBank(PaymentMethod bank) {
        this.bank = bank;
    }


    public CuotasCosts getCuotas() {
        return cuotas;
    }

    public void setCuotas(CuotasCosts cuotas) {
        this.cuotas = cuotas;
    }

    public boolean hasSelection() {
        return ammount != null && paymentMethod != null && bank != null && cuotas != null;
    }

    public void reset() {
        this.ammount = null;
        this.paymentMethod = null;
        this.bank = null;
        this.cuotas = null;
    }


}

