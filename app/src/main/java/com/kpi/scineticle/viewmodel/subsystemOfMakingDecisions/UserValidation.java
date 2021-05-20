package com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions;

import android.content.Context;
import android.util.Log;

import com.kpi.scineticle.model.InvalidPasswordException;
import com.kpi.scineticle.model.subsystemOfDataBase.user.User;
import com.kpi.scineticle.viewmodel.subsystemOutputData.UserOutputInfo;

public class UserValidation {

    private UserOutputInfo mUserOutputInfo;


    public UserValidation(Context context) {
        mUserOutputInfo = new UserOutputInfo(context);

    }


    public boolean UserDataValid(User userData) {

        if (!isValidName(userData)) {
            Log.d("UserDataValid", "n " + userData.getName());
            return false;
        }

        if (!isValidLastName(userData)) {
            return false;
        }

        if (!isValidPhone(userData)) {
            Log.d("UserDataValid", "p " + userData.getPhoneNumber());
            return false;
        }

        if (!isValidEmail(userData)) {
            Log.d("UserDataValid", "m " + userData.getEmail());
            return false;
        }


        if (!isValidPassword(userData)) {
            Log.d("UserDataValid", "pass " + userData.getPassword());
            return false;
        }

        return true;
    }

    public boolean isValidName(User user) {
        boolean result = true;
        if (user == null) {
            mUserOutputInfo.showError("Невірно ведено ім'я");
            return false;
        }
        if (!user.isValidName()) {
            mUserOutputInfo.showError("Невірно ведено ім'я");
            result = false;
        }

        return result;
    }

    public boolean isValidPhone(User user) {
        boolean result = true;
        if (user == null) {
            mUserOutputInfo.showError("Невірно ведений телефон");
            return false;
        }
        if (!user.isValidPhone()) {
            mUserOutputInfo.showError("Невірно ведений телефон");
            result = false;
        }

        return result;
    }

    public boolean isValidEmail(User user) {
        boolean result = true;
        if (user == null) {
            mUserOutputInfo.showError("Невірно ведена пошта");
            return false;
        }
        if (!user.isValidEmail()) {
            mUserOutputInfo.showError("Невірно ведена пошта");
            result = false;
        }

        return result;
    }

    public boolean isValidPassword(User user) {
        try {
            if (user.isValidPassword()) {
                return true;
            }
        } catch (InvalidPasswordException e) {
            mUserOutputInfo.showError(e.printMessage());
            return false;
        }
        return true;
    }

    public boolean isValidLastName(User user) {
        boolean result = true;
        if (user == null) {
            mUserOutputInfo.showError("Невірно вказане прізвище");
            return false;
        }
        if (!user.isValidLastName()) {
            mUserOutputInfo.showError("Невірно вказане прізвище");
            return false;
        }

        return result;
    }
}
