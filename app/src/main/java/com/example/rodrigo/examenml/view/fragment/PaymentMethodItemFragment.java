package com.example.rodrigo.examenml.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rodrigo.examenml.R;
import com.example.rodrigo.examenml.model.PaymentMethod;

import butterknife.BindView;

/**
 * Created by L0663298 on 22/01/2018.
 */

public class PaymentMethodItemFragment extends BaseFragment {

    private static final String PAYMENT_METHOD_BUNDLE = "PaymentMethod";

    private PaymentMethod paymentMethod;

    @BindView(R.id.fragment_payment_method_item_image)
    ImageView imageView;
    @BindView(R.id.fragment_payment_method_item_name)
    AppCompatTextView nameTextView;

    public static PaymentMethodItemFragment newInstance(PaymentMethod paymentMethod) {
        PaymentMethodItemFragment frag = new PaymentMethodItemFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(PAYMENT_METHOD_BUNDLE, paymentMethod);
        frag.setArguments(bundle);
        return frag;
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_payment_method_item;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        paymentMethod = getArguments().getParcelable(PAYMENT_METHOD_BUNDLE);
        if(paymentMethod != null) {
            nameTextView.setText(paymentMethod.getName());
            Glide.with(getActivity()).load(paymentMethod.getThumbnail()).fitCenter().into(imageView);
        }

    }


}
