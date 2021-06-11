package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.dissertations.Dissertation;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

public class DissertationViewModel extends AndroidViewModel {
    public MutableLiveData<String> authors = new MutableLiveData<>();
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> publish = new MutableLiveData<>();
    public MutableLiveData<String> type = new MutableLiveData<>();
    public MutableLiveData<String> year = new MutableLiveData<>();
    public MutableLiveData<String> countOfSheets = new MutableLiveData<>();
    public MutableLiveData<String> place = new MutableLiveData<>();

    private Application mApplication;
    private String userLogin;
    private Dissertation mDissertation;

   public void setValues(Dissertation dissertation) {
       authors.setValue(dissertation.getAuthors());
       name.setValue(dissertation.getName());
       publish.setValue(dissertation.getPublish());
       type.setValue(dissertation.getType());
       year.setValue(dissertation.getYear());
       countOfSheets.setValue(dissertation.getCountOfSheets());
       place.setValue(dissertation.getPlace());
   }

    public DissertationViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
        mDissertation = new Dissertation();
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Dissertation getDissertation() {
        mDissertation.setPublish(publish.getValue());
        mDissertation.setAuthors(authors.getValue());
        mDissertation.setPlace(place.getValue());
        mDissertation.setCountOfSheets(countOfSheets.getValue());
        mDissertation.setType(type.getValue());
        mDissertation.setYear(year.getValue());
        mDissertation.setName(name.getValue());
        mDissertation.setUserLogin(userLogin);

        return mDissertation;
    }

    public class NewDissertation {
        private final UserInputViewModel mDissertationInputViewModel;

        public NewDissertation() {
            mDissertationInputViewModel = new UserInputViewModel(mApplication);
        }

        public boolean createNewDissertation() {
           return mDissertationInputViewModel.insert(getDissertation());
        }
    }
}