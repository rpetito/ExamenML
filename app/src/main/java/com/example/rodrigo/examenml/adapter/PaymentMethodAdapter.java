package com.example.rodrigo.examenml.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by L0663298 on 22/01/2018.
 */

public class PaymentMethodAdapter extends RecyclerView.Adapter<PaymentMethodAdapter.PaymentMethodViewHolder> {


    @Override
    public PaymentMethodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PaymentMethodViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }



    public class PaymentMethodViewHolder extends RecyclerView.ViewHolder {


        public PaymentMethodViewHolder(View itemView) {
            super(itemView);
        }
    }


}
