package com.example.rodrigo.examenml.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import com.example.rodrigo.examenml.R;
import com.example.rodrigo.examenml.model.PaymentSelection;

import butterknife.BindView;

/**
 * Created by L0663298 on 26/01/2018.
 */

public class AmmountFragment extends BaseFragment {

    @BindView(R.id.fragment_ammount_continueButton)
    AppCompatButton continueButton;
    @BindView(R.id.fragment_ammount_ammountEditText)
    AppCompatEditText ammountEditText;


    @Override
    protected int getLayout() {
        return R.layout.fragment_ammount;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ammountEditText.getText().toString().isEmpty()) {
                    PaymentSelection.getInstance().setAmmount(ammountEditText.getText().toString());
                    changeFragment(new PaymentMethodFragment());
                }
            }
        });
    }

}
