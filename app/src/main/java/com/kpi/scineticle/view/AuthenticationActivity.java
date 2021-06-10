package com.kpi.scineticle.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ActivityAuthenticationBinding;
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.Alert;

public class AuthenticationActivity extends AppCompatActivity {

    public static final int CREATE_NEW_USER = 1;
    public static final int LOGIN_USER = 2;
    private ActivityAuthenticationBinding mBinding;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        mContext = this;
        initDataBinding();

        mBinding.buttonNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthenticationActivity.this, CreateNewUserActivity.class);
                startActivityForResult(intent, CREATE_NEW_USER);
            }
        });

        mBinding.buttonExistingUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthenticationActivity.this, LoginUserActivity.class);
                startActivityForResult(intent, LOGIN_USER);
            }
        });

    }

    private void initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_authentication);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_close, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.close) {
            alertAboutExit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void closeApp() {
        this.finishAffinity();
    }
    @Override
    public void onBackPressed() {
       alertAboutExit();

    }

    public void alertAboutExit() {
        Alert.createAlert(this, "Ви дійсно хочете вийти з програми?")
                .setPositiveButton("Так",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        closeApp();
                    }
                })
                .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();
    }

}