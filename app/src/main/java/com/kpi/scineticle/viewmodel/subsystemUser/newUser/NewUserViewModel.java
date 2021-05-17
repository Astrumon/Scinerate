package com.kpi.scineticle.viewmodel.subsystemUser.newUser;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kpi.scineticle.model.User;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.InputViewModel;


public class NewUserViewModel extends AndroidViewModel {
    private final InputViewModel<User> mInputViewModel;
    private final User mNewUser;

    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> lastName = new MutableLiveData<>();
    public MutableLiveData<String> phone = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();


    public NewUserViewModel(InputViewModel<User> inputViewModel) {
        super(inputViewModel.getApplication());
        mNewUser = new User();
        mInputViewModel = inputViewModel;
    }

    public boolean createNewUser() {
        setUserData();

        return mInputViewModel.insert(mNewUser);

    }

    private void setUserData() {
        mNewUser.setName(name.getValue());
        mNewUser.setPhoneNumber(phone.getValue());
        mNewUser.setEmail(email.getValue());
        mNewUser.setPassword(password.getValue());
        mNewUser.setLastName(lastName.getValue());
    }
}
