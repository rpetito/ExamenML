package com.example.rodrigo.examenml.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.rodrigo.examenml.R;
import com.example.rodrigo.examenml.adapter.ViewPagerAdapter;
import com.example.rodrigo.examenml.controller.BaseController;

import java.util.List;

import butterknife.BindView;

/**
 * Created by L0663298 on 22/01/2018.
 */

public abstract class SelectionFragment<T extends BaseController, M> extends ServiceFragment<T, M> {

    protected abstract ViewPagerAdapter getViewPagerAdapter(M item);

    @BindView(R.id.fragment_selection_screenView)
    View screenView;
    @BindView(R.id.fragment_selection_progressBar)
    ProgressBar progressBar;
    @BindView(R.id.fragment_selection_viewPager)
    ViewPager viewPager;
    @BindView(R.id.fragment_selection_continueButton)
    AppCompatButton continueButton;


    @Override
    protected int getLayout() {
        return R.layout.fragment_selection;
    }


    @Override
    protected void onChildViewCreated(View view, Bundle savedInstanceState) {
        setScreenView(screenView);
        setProgressBar(progressBar);
    }


    @Override
    protected boolean callServiceOnInit() {
        return true;
    }


    @Override
    protected View setActionView() {
        return continueButton;
    }

    @Override
    protected Fragment setNextFragment() {
        return null;
    }

    @Override
    public void onSuccess(M item) {
        super.onSuccess(item);
        viewPager.setAdapter(getViewPagerAdapter(item));
    }


}
