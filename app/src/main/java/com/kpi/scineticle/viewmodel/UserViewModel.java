package com.kpi.scineticle.viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kpi.scineticle.model.User;

public class UserViewModel extends ViewModel {
    private Context mContext;

    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> phone = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();

    private User mUser;

    public UserViewModel(User user, Context context){
        mContext = context;
        mUser = user;
    }

    public boolean fillUser() {
        mUser.setName(name.getValue());
        mUser.setPhoneNumber(phone.getValue());
        mUser.setEmail(email.getValue());

        if (!mUser.isValidName()) {
            Toast.makeText(mContext, "Невірно ведено ім'я", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!mUser.isValidPhone()) {
            Toast.makeText(mContext, "Невірно ведений телефон", Toast.LENGTH_SHORT).show();
            return false;
        }else if (!mUser.isValidEmail()) {
            Toast.makeText(mContext, "Невірно ведена пошта", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }



}
