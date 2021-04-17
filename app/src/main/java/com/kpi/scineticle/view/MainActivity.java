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

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
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
    public static final int EDIT_USER_REQUEST = 2;
    public static final int ARTICLE_REQUEST = 3;
    private UserCRUDViewModel mUserCRUDViewModel;
    private ActivityMainBinding mBinding;
    private UserAdapter mUserAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mUserAdapter = new UserAdapter();

        initDataBinding();
        setupListUserView(mBinding.recyclerUser);

        mBinding.buttonAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEditUserActivity.class);
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
                String textAlert = "Ви впевнені, що хочете видалити користувача?";
                Alert.createAlert(mContext, textAlert)
                       .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               deleteUser(viewHolder.getAdapterPosition());
                           }
                       })
                       .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               setupListUserView(mBinding.recyclerUser);
                           }
                       }).create().show();
            }
        }).attachToRecyclerView(mBinding.recyclerUser);

        mUserAdapter.setOnItemClickListener(new UserAdapter.onItemClickListener() {
            @Override
            public void onItemClick(User user) {
                Intent intent = new Intent(MainActivity.this, ScientificWorkMainActivity.class);
                startActivityForResult(intent, ARTICLE_REQUEST);
                Toast.makeText(MainActivity.this, "CLICK " + user, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(User user) {
                Intent intent = new Intent(MainActivity.this, AddEditUserActivity.class);
                intent.putExtra(AddEditUserActivity.EXTRA_NAME, user.getName());
                intent.putExtra(AddEditUserActivity.EXTRA_PHONE, user.getPhoneNumber());
                intent.putExtra(AddEditUserActivity.EXTRA_MAIL, user.getEmail());
                intent.putExtra(AddEditUserActivity.EXTRA_ID, user.getId());
                startActivityForResult(intent, EDIT_USER_REQUEST);
            }
        });
    }

    private void deleteUser(int position) {
        mUserCRUDViewModel.delete(mUserAdapter.getUserAt(position));
        Toast.makeText(MainActivity.this, "User deleted", Toast.LENGTH_SHORT).show();
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
                mUserAdapter.submitList(users);
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
            insertUser(data);
        } else if (requestCode == EDIT_USER_REQUEST && resultCode == RESULT_OK) {
            updateUser(data);
        } else {
            Toast.makeText(this, "User not saved", Toast.LENGTH_SHORT).show();
        }
    }

    private void insertUser(Intent data) {
        String name = data.getStringExtra(AddEditUserActivity.EXTRA_NAME);
        String phone = data.getStringExtra(AddEditUserActivity.EXTRA_PHONE);
        String email = data.getStringExtra(AddEditUserActivity.EXTRA_MAIL);

        User user = new User(name, email, phone);
        mUserCRUDViewModel.insert(user);
    }

    private void updateUser(Intent data) {
        int id = data.getIntExtra(AddEditUserActivity.EXTRA_ID, -1);
        if (id == -1) {
            Toast.makeText(this, "User can't be updated", Toast.LENGTH_SHORT).show();
            return;
        }

        String name = data.getStringExtra(AddEditUserActivity.EXTRA_NAME);
        String phone = data.getStringExtra(AddEditUserActivity.EXTRA_PHONE);
        String email = data.getStringExtra(AddEditUserActivity.EXTRA_MAIL);

        User user = new User(name, email, phone);
        user.setId(id);
        mUserCRUDViewModel.update(user);

        Toast.makeText(this, "User updated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deleteAllUsers:
                String textAlert = "Ви впевнені, що хочете видалити всіх користувачів?";
                Alert.createAlert(mContext, textAlert)
                        .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deleteAllUsers();
                            }
                        })
                        .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).create().show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void deleteAllUsers() {
        mUserCRUDViewModel.deleteAllUsers();
        Toast.makeText(this, "All users deleted", Toast.LENGTH_SHORT).show();
    }
}