package com.kpi.scineticle.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.kpi.scineticle.model.User;
import com.kpi.scineticle.model.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository mUserRepository;
    private LiveData<List<User>> allUsers;


    public UserViewModel(@NonNull Application application) {
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
