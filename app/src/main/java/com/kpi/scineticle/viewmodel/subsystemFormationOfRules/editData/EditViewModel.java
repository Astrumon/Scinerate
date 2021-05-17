package com.kpi.scineticle.viewmodel.subsystemFormationOfRules.editData;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public abstract class EditViewModel<T> extends AndroidViewModel {

    public EditViewModel(@NonNull Application application) {
        super(application);
    }

    public abstract void update(T t);
}
