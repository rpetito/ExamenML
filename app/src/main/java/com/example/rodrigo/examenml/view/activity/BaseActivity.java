package com.example.rodrigo.examenml.view.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.rodrigo.examenml.R;

/**
 * Created by rodrigo on 20/01/18.
 */

public abstract class BaseActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    protected abstract int getLayout();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
//        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }


    public void changeFragment(Fragment nextFragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.activity_main_fragmentContainer, nextFragment)
                .commit();
    }

    public void changeFragmentWithAnimation(Fragment nextFragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.activity_main_fragmentContainer, nextFragment)
                .setCustomAnimations(R.anim.enter_right_to_left, R.anim.out_right_to_left)
                .setCustomAnimations(
                        R.anim.enter_right_to_left,
                        R.anim.out_right_to_left ,
                        R.anim.enter_right_to_left,
                        R.anim.out_right_to_left
                )
                .commit();
    }


    @Override
    public void onBackStackChanged() {
        if(getSupportFragmentManager().getBackStackEntryCount() == 0 ) {
            finish();
        }
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Cuidado")
                .setMessage("Esta seguro que desea salir del proceso de pago?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }


}
