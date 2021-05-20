package com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.kpi.scineticle.model.User;

public abstract class InputViewModel<T> {

    public abstract boolean insert(T t);
    public abstract boolean inputDataForCheck(String email, String password);
    public abstract boolean checkExistingMail(User user);
}
