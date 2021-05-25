package com.kpi.scineticle.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ActivityLoginUserBinding;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.ExistingUserViewModel;

public class LoginUserActivity extends AppCompatActivity {
    private ActivityLoginUserBinding mBinding;
    private ExistingUserViewModel.ExistingUser mExistingUser;
    private static final int SCIENTIFIC_WORK_REQUEST = 5;
    public static final String LOGIN = "EMAIL_OF_AUTHORISATION_USER";

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
                    intent.putExtra("login", mExistingUser.getLogin());
                    startActivity(intent);
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