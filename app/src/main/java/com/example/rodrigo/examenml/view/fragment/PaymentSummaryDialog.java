package com.example.rodrigo.examenml.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rodrigo.examenml.R;
import com.example.rodrigo.examenml.adapter.PaymentSummaryAdapter;
import com.example.rodrigo.examenml.model.PaymentSelection;
import com.example.rodrigo.examenml.model.PaymentSummaryItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by L0663298 on 26/01/2018.
 */

public class PaymentSummaryDialog extends AppCompatDialog {

    RecyclerView recyclerView;
    AppCompatButton okButton;


    public PaymentSummaryDialog(Context context) {
        super(context);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_payment_summary);

        recyclerView = (RecyclerView) findViewById(R.id.dialog_payment_summary_recyclerView);
        okButton = (AppCompatButton) findViewById(R.id.dialog_payment_summary_okButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new PaymentSummaryAdapter(getList()));

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaymentSelection.getInstance().reset();
                dismiss();
            }
        });

    }


    private List<PaymentSummaryItem> getList() {

        List<PaymentSummaryItem> list = new ArrayList<>();
        list.add(new PaymentSummaryItem("Monto: ", "$ " + PaymentSelection.getInstance().getAmmount().toString()));
        list.add(new PaymentSummaryItem("Medio de pago: ", PaymentSelection.getInstance().getPaymentMethod().getName()));
        list.add(new PaymentSummaryItem("Banco: ", PaymentSelection.getInstance().getBank().getName()));
        list.add(new PaymentSummaryItem("Cuotas: ", PaymentSelection.getInstance().getCuotas().getCuotasValue()));
        return list;
    }

}
