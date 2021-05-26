package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kpi.scineticle.model.subsystemOfDataBase.thesis.Thesis;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

public class ThesisViewModel extends AndroidViewModel {
    public MutableLiveData<String> authors = new MutableLiveData<>();
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> namePublish = new MutableLiveData<>();
    public MutableLiveData<String> date = new MutableLiveData<>();
    public MutableLiveData<String> placeConference = new MutableLiveData<>();
    public MutableLiveData<String> year = new MutableLiveData<>();
    public MutableLiveData<String> sheets = new MutableLiveData<>();
    public MutableLiveData<String> placePublish = new MutableLiveData<>();

    private Application mApplication;
    private Thesis mThesis;
    private String userLogin;

    public ThesisViewModel(@NonNull Application application) {
        super(application);
        mThesis = new Thesis();
        mApplication = application;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Thesis getThesisData() {
        mThesis.setAuthors(authors.getValue());
        mThesis.setName(name.getValue());
        mThesis.setNamePublish(namePublish.getValue());
        mThesis.setDate(date.getValue());
        mThesis.setPlaceConference(placeConference.getValue());
        mThesis.setYear(year.getValue());
        mThesis.setSheets(sheets.getValue());
        mThesis.setPlacePublish(placePublish.getValue());
        mThesis.setLoginUser(userLogin);

        return mThesis;
    }

    public class NewThesis {
        private final UserInputViewModel mThesisInputViewModel;
        public NewThesis() {
            mThesisInputViewModel = new UserInputViewModel(mApplication);
        }

        public void createNewThesis() {
            mThesisInputViewModel.insert(getThesisData());
        }
    }



}