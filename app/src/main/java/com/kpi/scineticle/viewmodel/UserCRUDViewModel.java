package com.kpi.scineticle.viewmodel;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.kpi.scineticle.model.User;
import com.kpi.scineticle.model.UserRepository;
import com.kpi.scineticle.view.AddUserActivity;
import com.kpi.scineticle.view.MainActivity;

import java.util.List;

//TODO validation com.gueei.android.binding.validation.validators;
public class UserCRUDViewModel extends AndroidViewModel {
    private UserRepository mUserRepository;
    private LiveData<List<User>> allUsers;



    public UserCRUDViewModel(@NonNull Application application) {
        super(application);
        mUserRepository = new UserRepository(application);
        allUsers = mUserRepository.getAllUsers();
    }

    public void insert(User user) {
        mUserRepository.insert(user);
    }

    public void update(User user) {
        mUserRepository.update(user);
    }

    public void delete(User user) {
        mUserRepository.delete(user);
    }

    public void deleteAllUsers() {
        mUserRepository.deleteAllUsers();
    }



    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

}
