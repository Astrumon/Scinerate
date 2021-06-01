package com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions;

import android.content.Context;
import android.widget.Toast;

import com.kpi.scineticle.model.subsystemOfDataBase.user.User;
import com.kpi.scineticle.model.subsystemOfDataBase.user.UserRepository;
import com.kpi.scineticle.viewmodel.subsystemOutputData.UserOutputInfo;

public class UserFinder {
    private Context mContext;
    private UserRepository mUserRepository;
    private UserOutputInfo mUserOutputInfo;

    public UserFinder(Context context, UserRepository userRepository) {
        mContext = context;
        mUserOutputInfo = new UserOutputInfo(context);
        mUserRepository = userRepository;
    }

    public boolean existUserFromDB(User user) {

        User dbUser = mUserRepository.getUser(user.getEmail(), user.getPassword());
        if (dbUser == null) {
            mUserOutputInfo.showError("Користувача не існує, або невірно ведений пароль");
            return false;
        }

        if (dbUser.getEmail().equals(user.getEmail()) && dbUser.getPassword().equals(user.getPassword())) {
            return true;
        }

        return false;
    }

    public boolean isExistUserForRegistration(User user) {
        if (user.getEmail() == null) {
            return false;
        }

        User dbUser = mUserRepository.getUser(user.getEmail(), user.getPassword());
        Toast.makeText(mContext, dbUser + "", Toast.LENGTH_SHORT).show();
        if (dbUser == null) {
            return false;
        } else {
            mUserOutputInfo.showError("Користувач вже існує");
            return true;
        }
    }


}
