package com.kpi.scineticle.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ActivityAuthenticationBinding;
import com.kpi.scineticle.model.User;
import com.kpi.scineticle.viewmodel.UserCRUDViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.newUser.NewUserViewModel;

import java.util.List;

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