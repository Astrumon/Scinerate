package com.kpi.scineticle.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ActivityLoginUserBinding;
import com.kpi.scineticle.viewmodel.UserCRUDViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.InputViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.ExistingUserViewModel;

public class LoginUserActivity extends AppCompatActivity {
    private Context mContext;
    private ActivityLoginUserBinding mBinding;
    private ExistingUserViewModel mExistingUserViewModel;
    private static final int SCIENTIFIC_WORK_REQUEST = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        mContext = this;
        initDataBinding();

        mBinding.btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mExistingUserViewModel.loginUser()) {
                    Intent intent = new Intent(LoginUserActivity.this, ScientificWorkMainActivity.class);
                    startActivityForResult(intent, SCIENTIFIC_WORK_REQUEST);
                }
            }
        });
    }

    private void initDataBinding() {
        UserInputViewModel inputViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(UserInputViewModel.class);
        mExistingUserViewModel = new ExistingUserViewModel(inputViewModel);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_user);
        mBinding.setExistingUser(mExistingUserViewModel);


    }
}