package com.kpi.scineticle.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ActivityMainBinding;
import com.kpi.scineticle.model.User;
import com.kpi.scineticle.viewmodel.UserCRUDViewModel;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static final int ADD_USER_REQUEST = 1;
    private UserCRUDViewModel mUserCRUDViewModel;
    private ActivityMainBinding mBinding;
    private UserAdapter mUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserAdapter = new UserAdapter();

        initDataBinding();
        setupListUserView(mBinding.recyclerUser);
        
        mBinding.buttonAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivityForResult(intent, ADD_USER_REQUEST);
            }
        });

       new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
           @Override
           public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
               return false;
           }

           @Override
           public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                mUserCRUDViewModel.delete(mUserAdapter.getUserAt(viewHolder.getAdapterPosition()));
               Toast.makeText(MainActivity.this, "User deleted", Toast.LENGTH_SHORT).show();
           }
       }).attachToRecyclerView(mBinding.recyclerUser);
    }

    private void initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mUserCRUDViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(UserCRUDViewModel.class);
    }

    private void setupListUserView(RecyclerView recyclerView) {

        mUserCRUDViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                mUserAdapter.setUsers(users);
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mUserAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_USER_REQUEST && resultCode == RESULT_OK) {
            String name = data.getStringExtra(AddUserActivity.EXTRA_NAME);
            String phone = data.getStringExtra(AddUserActivity.EXTRA_PHONE);
            String email = data.getStringExtra(AddUserActivity.EXTRA_MAIL);

            User user = new User(name, email, phone);
            mUserCRUDViewModel.insert(user);

            Toast.makeText(this, "User saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "User not saved", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deleteAllUsers:
                mUserCRUDViewModel.deleteAllUsers();
                Toast.makeText(this, "All users deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}