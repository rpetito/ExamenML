package com.example.rodrigo.examenml.view.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rodrigo.examenml.R;
import com.example.rodrigo.examenml.view.fragment.WelcomeFragment;

public class MainActivity extends BaseActivity {


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeFragment(new WelcomeFragment());
    }

}
