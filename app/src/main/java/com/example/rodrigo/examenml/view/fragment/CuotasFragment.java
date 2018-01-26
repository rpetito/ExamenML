package com.example.rodrigo.examenml.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.rodrigo.examenml.R;
import com.example.rodrigo.examenml.adapter.CuotasAdapter;
import com.example.rodrigo.examenml.controller.PaymentController;
import com.example.rodrigo.examenml.model.CuotasCosts;
import com.example.rodrigo.examenml.model.PaymentSelection;
import com.example.rodrigo.examenml.util.RecyclerViewItemClickListener;

import java.util.List;

import butterknife.BindView;


/**
 * Created by L0663298 on 26/01/2018.
 */

public class CuotasFragment extends ServiceFragment<PaymentController, List<CuotasCosts>> implements RecyclerViewItemClickListener<CuotasCosts> {


    @BindView(R.id.fragment_cuotas_recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.fragment_cuotas_continueButton)
    AppCompatButton continueButton;


    @Override
    protected int getLayout() {
        return R.layout.fragment_cuotas;
    }


    @Override
    protected void onChildViewCreated(View view, Bundle savedInstanceState) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    @Override
    protected boolean callServiceOnInit() {
        return true;
    }


    @Override
    protected void callService() {
        getServiceController().getCuotas(this);
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
        return new WelcomeFragment();
    }


    @Override
    public void onSuccess(List<CuotasCosts> item) {
        CuotasAdapter adapter = new CuotasAdapter(item, this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void nextStep() {
        if(PaymentSelection.getInstance().getCuotas() != null) {
            super.nextStep();
        }
    }


    @Override
    public void onItemClicked(CuotasCosts item, int position) {
        PaymentSelection.getInstance().setCuotas(item);
    }


}
