package com.kpi.scineticle.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ActivityAddUserBinding;
import com.kpi.scineticle.model.User;
import com.kpi.scineticle.viewmodel.UserViewModel;
import com.kpi.scineticle.viewmodel.UserViewModelFactory;

public class AddUserActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.kpi.scineticle.EXTRA_NAME";
    public static final String EXTRA_PHONE = "com.kpi.scineticle.EXTRA_PHONE";
    public static final String EXTRA_MAIL = "com.kpi.scineticle.EXTRA_MAIL";

    private ActivityAddUserBinding mBinding;
    private UserViewModel mUserViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        initBinding();
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24);
        setTitle("Add user");
    }

    private void initBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_user);
        mUserViewModel = new ViewModelProvider(this, new UserViewModelFactory(new User(), this))
                .get(UserViewModel.class);
        mBinding.setUserViewModel(mUserViewModel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_user_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_user:
                if (mUserViewModel.fillUser()) saveUser();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveUser() {
        String name = mBinding.editTextName.getText().toString();
        String phone = mBinding.editTextPhone.getText().toString();
        String email = mBinding.editTextMail.getText().toString();

        if (name.trim().isEmpty() || phone.trim().isEmpty() || email.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a name, phone and mail", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_NAME, name);
        data.putExtra(EXTRA_PHONE, phone);
        data.putExtra(EXTRA_MAIL, email);

        setResult(RESULT_OK, data);
        finish();
    }
}