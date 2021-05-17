package com.kpi.scineticle.viewmodel.subsystemFormationOfRules.deleteData;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public abstract class DeleteViewModel<T> extends AndroidViewModel {
    public DeleteViewModel(@NonNull Application application) {
        super(application);
    }

    abstract void delete(T t);
    abstract void deleteAllUsers();
}
