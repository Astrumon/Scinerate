package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.patents.Patent;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

public class PatentsViewModel extends AndroidViewModel {
    public MutableLiveData<String> authors = new MutableLiveData<>();
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> namePatentOwner = new MutableLiveData<>();
    public MutableLiveData<String> country = new MutableLiveData<>();
    public MutableLiveData<String> number = new MutableLiveData<>();
    public MutableLiveData<String> date = new MutableLiveData<>();


    private Application mApplication;
    private String userLogin;
    private Patent mPatent;

    public PatentsViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
        mPatent = new Patent();
    }

   public void setValues(Patent patent) {
       authors.setValue(patent.getAuthors());
       name.setValue(patent.getName());
       namePatentOwner.setValue(patent.getNamePatentOwner());
       country.setValue(patent.getCountry());
       number.setValue(patent.getNumber());
       date.setValue(patent.getDate());
   }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Patent getPatentData() {
        mPatent.setAuthors(authors.getValue());
        mPatent.setCountry(country.getValue());
        mPatent.setName(name.getValue());
        mPatent.setNumber(number.getValue());
        mPatent.setDate(date.getValue());
        mPatent.setNamePatentOwner(namePatentOwner.getValue());
        mPatent.setUserLogin(userLogin);

        return mPatent;
    }

    public class NewPatent {
        private final UserInputViewModel mPatentInputViewModel;

        public NewPatent() {
            mPatentInputViewModel = new UserInputViewModel(mApplication);
        }

        public void createNewPatent() {
            mPatentInputViewModel.insert(getPatentData());
        }
    }
}