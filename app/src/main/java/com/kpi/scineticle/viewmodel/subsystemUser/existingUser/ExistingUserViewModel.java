package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kpi.scineticle.model.User;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.deleteData.DeleteViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.deleteData.UserDeleteViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.editData.EditViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.editData.UserEditViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.InputViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

public class ExistingUserViewModel extends AndroidViewModel {

    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    private Application mApplication;

    public ExistingUserViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
    }

    public class ExistingUser {
        private InputViewModel mInputViewModel;
        private EditViewModel mEditViewModel;
        private DeleteViewModel mDeleteViewModel;

        public ExistingUser() {
            mInputViewModel = new UserInputViewModel(mApplication);
            mEditViewModel = new UserEditViewModel(mApplication);
            mDeleteViewModel = new UserDeleteViewModel(mApplication);
        }

        public boolean loginUser() {
            Log.d("EXISTINGUSER", "email: " + email.getValue() + ", pass: " + password.getValue());
            return mInputViewModel.inputDataForCheck(email.getValue(), password.getValue());
        }
    }

}
