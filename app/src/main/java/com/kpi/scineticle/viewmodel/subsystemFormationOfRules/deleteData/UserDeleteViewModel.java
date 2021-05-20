package com.kpi.scineticle.viewmodel.subsystemFormationOfRules.deleteData;

import android.app.Application;

import androidx.annotation.NonNull;

import com.kpi.scineticle.model.subsystemOfDataBase.user.User;
import com.kpi.scineticle.model.subsystemOfDataBase.user.UserRepository;


public class UserDeleteViewModel extends DeleteViewModel<User> {
    private UserRepository mUserRepository;

    public UserDeleteViewModel(@NonNull Application application) {
        mUserRepository = new UserRepository(application);
    }

    public void delete(User user) {
        mUserRepository.delete(user);
    }

    public void deleteAllUsers() {
        mUserRepository.deleteAllUsers();
    }
}
