package com.example.rodrigo.examenml.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rodrigo.examenml.view.activity.BaseActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by rodrigo on 20/01/18.
 */

public abstract class BaseFragment extends Fragment {

    protected abstract int getLayout();

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void changeFragment(Fragment nextFragment) {
        ((BaseActivity)getActivity()).changeFragment(nextFragment);
    }

    public void changeFragmentWithAnimation(Fragment nextFragment) {
        ((BaseActivity)getActivity()).changeFragmentWithAnimation(nextFragment);
    }


}
