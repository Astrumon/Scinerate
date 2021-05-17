package com.kpi.scineticle.viewmodel.subsystemFormationOfRules.editData;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.kpi.scineticle.model.User;
import com.kpi.scineticle.model.subsystemOfDataBase.UserRepository;

public class UserEditViewModel extends EditViewModel<User> {
    private UserRepository mUserRepository;

    public UserEditViewModel(@NonNull Application application) {
        super(application);
        mUserRepository = new UserRepository(application);
    }

    public void update(User user) {
        mUserRepository.update(user);
    }
}
