package com.example.rodrigo.examenml.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rodrigo.examenml.R;
import com.example.rodrigo.examenml.model.PaymentSummaryItem;

import java.util.List;

/**
 * Created by L0663298 on 26/01/2018.
 */

public class PaymentSummaryAdapter extends RecyclerView.Adapter<PaymentSummaryAdapter.ViewHolder> {

    private List<PaymentSummaryItem> list;


    public PaymentSummaryAdapter(List<PaymentSummaryItem> list) {
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_payment_summary, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.value.setText(list.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView title;
        AppCompatTextView value;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.adapter_payment_summary_title);
            value = itemView.findViewById(R.id.adapter_payment_summary_value);
        }

    }

}
