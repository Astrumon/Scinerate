package com.kpi.scineticle.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ActivityMainBinding;
import com.kpi.scineticle.model.User;
import com.kpi.scineticle.viewmodel.UserViewModel;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static final int ADD_USER_REQUEST = 1;
    private UserViewModel mUserViewModel;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initDataBinding();
        setupListUserView(mBinding.recyclerUser);

        mBinding.buttonAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivityForResult(intent, ADD_USER_REQUEST);
            }
        });
    }

    private void initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mUserViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(UserViewModel.class);
    }

    private void setupListUserView(RecyclerView recyclerView) {
        UserAdapter userAdapter = new UserAdapter();
        mUserViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                userAdapter.setUsers(users);
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_USER_REQUEST && resultCode == RESULT_OK) {
            String name = data.getStringExtra(AddUserActivity.EXTRA_NAME);
            String phone = data.getStringExtra(AddUserActivity.EXTRA_PHONE);
            String mail = data.getStringExtra(AddUserActivity.EXTRA_MAIL);

            User user = new User(name, mail, phone);
            mUserViewModel.insert(user);

            Toast.makeText(this, "User saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "User not saved", Toast.LENGTH_SHORT).show();
        }
    }
}