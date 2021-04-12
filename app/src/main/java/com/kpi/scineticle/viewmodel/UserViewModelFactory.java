package com.kpi.scineticle.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.kpi.scineticle.model.User;

public class UserViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private User mUser;
    private Context mContext;

    public UserViewModelFactory(User user, Context context) {
        mUser = user;
        mContext = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new UserViewModel(mUser, mContext);
    }
}
