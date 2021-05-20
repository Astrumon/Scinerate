package com.kpi.scineticle.viewmodel.subsystemUser.newUser;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.user.User;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.InputViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;


public class NewUserViewModel extends AndroidViewModel {

    private final User mNewUser;
    private Application mApplication;

    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> lastName = new MutableLiveData<>();
    public MutableLiveData<String> phone = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();


    public NewUserViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
        mNewUser = new User();
    }

    public User getUserData() {
        mNewUser.setName(name.getValue());
        mNewUser.setPhoneNumber(phone.getValue());
        mNewUser.setEmail(email.getValue());
        mNewUser.setPassword(password.getValue());
        mNewUser.setLastName(lastName.getValue());

        return mNewUser;
    }

    public class NewUser {
        private final InputViewModel<User> mInputViewModel;

        public NewUser() {
            mInputViewModel = new UserInputViewModel(mApplication);
        }

        public boolean createNewUser() {
            Log.d("NEWUSER", "user: " + getUserData());

            return mInputViewModel.insert(getUserData());
        }


    }


}
