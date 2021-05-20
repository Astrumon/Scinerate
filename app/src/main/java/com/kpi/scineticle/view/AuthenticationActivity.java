package com.kpi.scineticle.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ActivityAuthenticationBinding;

public class AuthenticationActivity extends AppCompatActivity {

    public static final int CREATE_NEW_USER = 1;
    public static final int LOGIN_USER = 2;
    private ActivityAuthenticationBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

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


}