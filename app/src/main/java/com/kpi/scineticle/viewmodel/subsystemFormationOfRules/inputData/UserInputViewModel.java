package com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.kpi.scineticle.model.User;
import com.kpi.scineticle.model.subsystemOfDataBase.UserRepository;
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.UserFinder;
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.UserValidation;

import static android.content.ContentValues.TAG;

public class UserInputViewModel extends InputViewModel<User> {

    private final UserRepository mUserRepository;
    private UserValidation mUserValidation;
    private UserFinder mUserFinder;

    public UserInputViewModel(@NonNull Application application) {
        mUserRepository = new UserRepository(application);
        mUserValidation = new UserValidation(application.getApplicationContext());
        mUserFinder = new UserFinder(application.getApplicationContext(), mUserRepository);
    }

    @Override
    public boolean insert(User user) {
        if (mUserValidation.UserDataValid(user) && !checkExistingMail(user)) {
            mUserRepository.insert(user);
            return true;
        }
        return false;
    }


    public boolean inputDataForCheck(String email, String password) {
        Log.d("UserInputDataForCheck", "email: " + email + ", password: " + password);
        boolean result = false;
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        if (mUserValidation.isValidEmail(user) && mUserValidation.isValidPassword(user)) {
            result = mUserFinder.existUserFromDB(user);
        }
        return  result;
    }

    public boolean checkExistingMail(User user)  {
        Log.d("UserInputDataForCheck", "email: " + user);
        boolean result = false;


        if (mUserValidation.isValidEmail(user)) {
            result = mUserFinder.isExistUserForRegistration(user);
        }
        return result;

    }


}
