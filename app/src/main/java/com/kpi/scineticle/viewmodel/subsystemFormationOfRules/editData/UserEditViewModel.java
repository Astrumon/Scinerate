package com.kpi.scineticle.viewmodel.subsystemFormationOfRules.editData;

import android.app.Application;

import androidx.annotation.NonNull;

import com.kpi.scineticle.model.subsystemOfDataBase.user.User;
import com.kpi.scineticle.model.subsystemOfDataBase.user.UserRepository;

public class UserEditViewModel extends EditViewModel<User> {
    private UserRepository mUserRepository;

    public UserEditViewModel(@NonNull Application application) {
        mUserRepository = new UserRepository(application);
    }

    public void update(User user) {
        mUserRepository.update(user);
    }
}
