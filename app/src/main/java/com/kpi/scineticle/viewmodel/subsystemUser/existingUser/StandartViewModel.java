package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kpi.scineticle.model.subsystemOfDataBase.standarts.Standart;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

public class StandartViewModel extends AndroidViewModel {
    public MutableLiveData<String> nameOfOrg = new MutableLiveData<>();
    public MutableLiveData<String> yearPublish = new MutableLiveData<>();
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> codeLetter = new MutableLiveData<>();
    public MutableLiveData<String> codeNumber = new MutableLiveData<>();
    public MutableLiveData<String> publish = new MutableLiveData<>();
    public MutableLiveData<String> placePublish = new MutableLiveData<>();

    private Application mApplication;
    private String userLogin;
    private Standart mStandart;

    public StandartViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
        mStandart = new Standart();
    }

    public void setValues(Standart standart) {
        nameOfOrg.setValue(standart.getNameOfOrg());
        yearPublish.setValue(standart.getYearPublish());
        name.setValue(standart.getName());
        codeLetter.setValue(standart.getCodeLetter());
        codeNumber.setValue(standart.getCodeNumber());
        publish.setValue(standart.getPublish());
        placePublish.setValue(standart.getPlacePublish());
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Standart getStandartData() {
        mStandart.setNameOfOrg(nameOfOrg.getValue());
        mStandart.setYearPublish(yearPublish.getValue());
        mStandart.setName(name.getValue());
        mStandart.setCodeLetter(codeLetter.getValue());
        mStandart.setCodeNumber(codeNumber.getValue());
        mStandart.setPublish(publish.getValue());
        mStandart.setPlacePublish(placePublish.getValue());
        mStandart.setUserLogin(userLogin);

        return mStandart;
    }

    public class NewStandart {
        private final UserInputViewModel mStandartInputViewModel;

        public NewStandart() {
            mStandartInputViewModel = new UserInputViewModel(mApplication);
        }

        public void createNewStandart() {
            mStandartInputViewModel.insert(getStandartData());
        }
    }

}