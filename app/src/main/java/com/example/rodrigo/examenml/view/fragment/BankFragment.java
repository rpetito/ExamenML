package com.example.rodrigo.examenml.view.fragment;

import android.support.v4.app.Fragment;

import com.example.rodrigo.examenml.R;
import com.example.rodrigo.examenml.adapter.ViewPagerAdapter;
import com.example.rodrigo.examenml.controller.PaymentController;
import com.example.rodrigo.examenml.model.PaymentMethod;
import com.example.rodrigo.examenml.model.PaymentSelection;
import com.example.rodrigo.examenml.util.SelectedItemListener;

import java.util.List;

/**
 * Created by rodrigo on 21/01/18.
 */

public class BankFragment extends SelectionFragment<PaymentController, List<PaymentMethod>> implements SelectedItemListener<PaymentMethod> {

    private PaymentMethod bank;

    @Override
    protected ViewPagerAdapter getViewPagerAdapter(List<PaymentMethod> item) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        for(PaymentMethod pm : item) {
            PaymentMethodItemFragment frag = PaymentMethodItemFragment.newInstance(pm);
            frag.setSelectedItemListener(this);
            adapter.addFragment(frag);
        }
        return adapter;
    }



    @Override
    protected void callService() {
        getServiceController().getBanks(this);
    }


    @Override
    protected PaymentController setServiceController() {
        return new PaymentController();
    }


    @Override
    public void itemSelected(PaymentMethod item) {
        bank = item;
        setSelectedItemText(item.getName());
    }

    @Override
    protected void nextStep() {
        if(bank != null) {
            PaymentSelection.getInstance().setBank(bank);
            super.nextStep();
        }
    }


    @Override
    protected Fragment setNextFragment() {
        return new CuotasFragment();
    }


}
