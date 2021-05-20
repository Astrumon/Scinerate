package com.kpi.scineticle.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ActivityLoginUserBinding;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.ExistingUserViewModel;

public class LoginUserActivity extends AppCompatActivity {
    private ActivityLoginUserBinding mBinding;
    private ExistingUserViewModel.ExistingUser mExistingUser;
    private static final int SCIENTIFIC_WORK_REQUEST = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        initDataBinding();

        mBinding.btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mExistingUser.loginUser()) {
                    Intent intent = new Intent(LoginUserActivity.this, ScientificWorkMainActivity.class);
                    startActivityForResult(intent, SCIENTIFIC_WORK_REQUEST);
                }
            }
        });
    }

    private void initDataBinding() {
        ExistingUserViewModel mExistingUserViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(ExistingUserViewModel.class);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_user);
        mBinding.setExistingUser(mExistingUserViewModel);

        mExistingUser = mExistingUserViewModel.new ExistingUser();
    }
}