package com.example.rodrigo.examenml.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rodrigo.examenml.R;
import com.example.rodrigo.examenml.controller.BaseController;
import com.example.rodrigo.examenml.view.activity.BaseActivity;

import butterknife.BindView;

/**
 * Created by rodrigo on 20/01/18.
 */

public class WelcomeFragment extends BaseFragment {

    @BindView(R.id.fragment_welcome_button)
    AppCompatButton continueButton;

    @Override
    protected int getLayout()    {
        return R.layout.fragment_welcome;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragmentWithAnimation(new AmmountFragment());
            }
        });
    }



}
