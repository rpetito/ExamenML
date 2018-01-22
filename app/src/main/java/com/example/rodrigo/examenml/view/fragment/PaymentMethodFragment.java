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
import com.example.rodrigo.examenml.adapter.ViewPagerAdapter;
import com.example.rodrigo.examenml.controller.PaymentController;
import com.example.rodrigo.examenml.model.PaymentMethod;

import java.util.List;

import butterknife.BindView;

/**
 * Created by rodrigo on 21/01/18.
 */

public class PaymentMethodFragment extends SelectionFragment<PaymentController, List<PaymentMethod>> {


    @Override
    protected void callService() {
        getServiceController().getPaymentMethods(this);
    }

    @Override
    protected PaymentController setServiceController() {
        return new PaymentController();
    }


    @Override
    protected Fragment setNextFragment() {
        return new BankFragment();
    }

    @Override
    protected ViewPagerAdapter getViewPagerAdapter(List<PaymentMethod> item) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        for(PaymentMethod pm : item) {
            adapter.addFragment(PaymentMethodItemFragment.newInstance(pm));
        }
        return adapter;
    }


}
