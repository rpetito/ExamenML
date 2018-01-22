package com.example.rodrigo.examenml.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.rodrigo.examenml.R;
import com.example.rodrigo.examenml.controller.PaymentController;
import com.example.rodrigo.examenml.model.PaymentMethod;
import com.example.rodrigo.examenml.util.ResponseListener;

import java.util.List;

import butterknife.BindView;

/**
 * Created by rodrigo on 21/01/18.
 */

public class PaymentMethodFragment extends ServiceFragment<PaymentController> implements ResponseListener<List<PaymentMethod>> {

    @BindView(R.id.fragment_payment_method_screenView)
    View screenView;
    @BindView(R.id.fragment_payment_method_recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.fragment_payment_method_progressBar)
    ProgressBar progressBar;
    @BindView(R.id.fragment_payment_method_continueButton)
    AppCompatButton continueButton;

    @Override
    protected int getLayout() {
        return R.layout.fragment_payment_method;
    }

    @Override
    protected void onChildViewCreated(View view, Bundle savedInstanceState) {
        setScreenView(screenView);
        setProgressBar(progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected boolean callServiceOnInit() {
        return true;
    }

    @Override
    protected void callService() {
        getServiceController().getPaymentMethods(this);
    }

    @Override
    protected PaymentController setServiceController() {
        return new PaymentController();
    }

    @Override
    protected View setActionView() {
        return continueButton;
    }

    @Override
    protected Fragment setNextFragment() {
        return new BankFragment();
    }


    @Override
    public void onSuccess(List<PaymentMethod> item) {
        Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
    }


}
