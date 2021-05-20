package com.kpi.scineticle.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ActivityCreateNewUserBinding;
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.Alert;
import com.kpi.scineticle.viewmodel.subsystemUser.newUser.NewUserViewModel;

public class CreateNewUserActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "com.kpi.scineticle.EXTRA_ID";
    public static final String EXTRA_NAME = "com.kpi.scineticle.EXTRA_NAME";
    public static final String EXTRA_PHONE = "com.kpi.scineticle.EXTRA_PHONE";
    public static final String EXTRA_MAIL = "com.kpi.scineticle.EXTRA_MAIL";
    public static final String EXTRA_LAST_NAME = "com.kpi.scineticle.EXTRA_LAST_NAME";

    private ActivityCreateNewUserBinding mBinding;
    private NewUserViewModel.NewUser mNewUser;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_user);

        mContext = this;

        initBinding();
        mBinding.btnSaveNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
    }

    private void initBinding() {
        NewUserViewModel newUserViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(NewUserViewModel.class);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_create_new_user);
        mBinding.setNewUserViewModel(newUserViewModel);

        mNewUser = newUserViewModel.new NewUser();

    }

    private void createUser() {
        String password = mBinding.getNewUserViewModel().password.getValue();
        String confirmPassword = mBinding.editTextConfirmPassword.getText().toString();
        if ((password.equals(confirmPassword))) {

            String textAlert = "Зберегти дані?";
            Alert.createAlert(mContext, textAlert)
                    .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (mNewUser.createNewUser()) {
                                Toast.makeText(mContext, "Новий користувач успішно створений", Toast.LENGTH_SHORT).show();
                                saveUser();
                            }
                        }
                    })
                    .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create().show();
        } else {
            Toast.makeText(this, "Поля для ведення паролів мають співпадати", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveUser() {
        String name = mBinding.getNewUserViewModel().name.getValue();
        String lastName = mBinding.getNewUserViewModel().lastName.getValue();
        String phone = mBinding.getNewUserViewModel().phone.getValue();
        String email = mBinding.getNewUserViewModel().email.getValue();
        String password = mBinding.getNewUserViewModel().password.getValue();
        String confirmPassword = mBinding.editTextConfirmPassword.getText().toString();

        if (name.trim().isEmpty() || phone.trim().isEmpty() || email.trim().isEmpty()
                || lastName.trim().isEmpty() || password.trim().isEmpty()) {
            Toast.makeText(this, "Будь-ласка, заповніть всі поля", Toast.LENGTH_SHORT).show();
            return;
        } else if (!(password.equals(confirmPassword))) {
            Toast.makeText(this, "Поля для ведення паролів мають співпадати", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_NAME, name);
        data.putExtra(EXTRA_LAST_NAME, lastName);
        data.putExtra(EXTRA_PHONE, phone);
        data.putExtra(EXTRA_MAIL, email);


        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
        }

        Toast.makeText(this, phone, Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK, data);
        finish();
    }


}