package com.kpi.scineticle.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ActivityAddUserBinding;
import com.kpi.scineticle.databinding.ActivityCreateNewUserBinding;
import com.kpi.scineticle.model.User;
import com.kpi.scineticle.viewmodel.UserCRUDViewModel;
import com.kpi.scineticle.viewmodel.UserViewModel;
import com.kpi.scineticle.viewmodel.UserViewModelFactory;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.newUser.NewUserViewModel;

import java.util.Objects;

public class CreateNewUserActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "com.kpi.scineticle.EXTRA_ID";
    public static final String EXTRA_NAME = "com.kpi.scineticle.EXTRA_NAME";
    public static final String EXTRA_PHONE = "com.kpi.scineticle.EXTRA_PHONE";
    public static final String EXTRA_MAIL = "com.kpi.scineticle.EXTRA_MAIL";
    public static final String EXTRA_LAST_NAME = "com.kpi.scineticle.EXTRA_LAST_NAME";

    private ActivityCreateNewUserBinding mBinding;
    private NewUserViewModel mNewUserViewModel;
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
        UserInputViewModel userInputViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(UserInputViewModel.class);
        mNewUserViewModel = new NewUserViewModel(userInputViewModel);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_create_new_user);
        mBinding.setNewUserViewModel(mNewUserViewModel);
    }

    private void createUser() {
        String password = mBinding.editTextPassword.getText().toString();
        String confirmPassword = mBinding.editTextConfirmPassword.getText().toString();
        if ((password.equals(confirmPassword))) {

            String textAlert = "Зберегти дані?";
            Alert.createAlert(mContext, textAlert)
                    .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (mNewUserViewModel.createNewUser()) {
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
        String name = mBinding.editTextName.getText().toString();
        String lastName = mBinding.editTextLastName.getText().toString();
        String phone = mBinding.editTextPhone.getText().toString();
        String email = mBinding.editTextMail.getText().toString();
        String password = mBinding.editTextPassword.getText().toString();
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