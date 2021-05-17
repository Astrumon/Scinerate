package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kpi.scineticle.model.User;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.deleteData.DeleteViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.editData.EditViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.InputViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

public class ExistingUserViewModel extends AndroidViewModel {

    private InputViewModel mInputViewModel;
    private EditViewModel mEditViewModel;
    private DeleteViewModel mDeleteViewModel;

    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    public ExistingUserViewModel(@NonNull Application application) {
        super(application);
    }

    public ExistingUserViewModel(InputViewModel inputViewModel) {
        super(inputViewModel.getApplication());
        Log.d("EXISTINGUSER", "test");
        mInputViewModel = inputViewModel;
    }

    public ExistingUserViewModel(EditViewModel editViewModel) {
        super(editViewModel.getApplication());
        mEditViewModel = editViewModel;
    }

    public ExistingUserViewModel(DeleteViewModel deleteViewModel) {
        super(deleteViewModel.getApplication());
        mDeleteViewModel = deleteViewModel;
    }

    public boolean loginUser() {
        Log.d("EXISTINGUSER", "email: " + email.getValue() + ", pass: " + password.getValue());

        return mInputViewModel.inputDataForCheck(email.getValue(), password.getValue());
    }


}
