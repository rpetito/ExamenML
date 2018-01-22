package com.example.rodrigo.examenml.view.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ProgressBar;

import com.example.rodrigo.examenml.controller.BaseController;
import com.example.rodrigo.examenml.model.ServiceError;
import com.example.rodrigo.examenml.util.ResponseListener;
import com.example.rodrigo.examenml.view.activity.BaseActivity;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rodrigo on 20/01/18.
 */

public abstract class ServiceFragment<T extends BaseController, M> extends BaseFragment implements View.OnClickListener, ResponseListener<M> {


    protected abstract void onChildViewCreated(View view, Bundle savedInstanceState);
    protected abstract boolean callServiceOnInit();
    protected abstract void callService();
    protected abstract T setServiceController();
    protected abstract View setActionView();
    protected abstract Fragment setNextFragment();

    private View actionView;
    private Fragment nextFragment;

    private T serviceController;
    private ProgressBar progressBar;
    private View screenView;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.serviceController = setServiceController();
        this.nextFragment = setNextFragment();
        this.actionView = setActionView();
        this.actionView.setOnClickListener(this);
        onChildViewCreated(view, savedInstanceState);
        if(callServiceOnInit()) {
            showProgressBar();
            callService();
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        this.serviceController.onPause();
    }


    @Override
    public void onResume() {
        super.onResume();
        this.serviceController.onResume();
    }


    protected void nextStep() {
        ((BaseActivity)getActivity()).changeFragmentWithAnimation(nextFragment);
    }


    @Override
    public void onSuccess(M item) {
        hideProgressBar();
    }

    @Override
    public void onError(ServiceError error) {
        showServiceErrorDialog(error);
    }

    @Override
    public void onClick(View view) {
        nextStep();
    }




    public void hideProgressBar() {
        if(progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
        showScreenView();
    }

    public void showProgressBar() {
        if(progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
        hideScreenView();
    }

    public void hideScreenView() {
        if(screenView != null) {
            screenView.setVisibility(View.GONE);
        }
    }

    public void showScreenView() {
        if(screenView != null) {
            screenView.setVisibility(View.VISIBLE);
        }
    }


    private void showServiceErrorDialog(ServiceError error) {
        new AlertDialog.Builder(getActivity())
                .setTitle(error.getTitle())
                .setMessage(error.getMessage())
                .setPositiveButton("Reintentar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        callService();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }


    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public void setScreenView(View screenView) {
        this.screenView = screenView;
    }

    public T getServiceController() {
        return this.serviceController;
    }





}
