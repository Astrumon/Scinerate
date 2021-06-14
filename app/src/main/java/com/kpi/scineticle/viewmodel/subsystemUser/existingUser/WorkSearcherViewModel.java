package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class WorkSearcherViewModel extends AndroidViewModel {
    public MutableLiveData<String> search = new MutableLiveData<>();

    public WorkSearcherViewModel(@NonNull Application application) {
        super(application);
    }
}
