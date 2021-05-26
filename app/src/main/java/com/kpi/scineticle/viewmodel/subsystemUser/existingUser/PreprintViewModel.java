package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.preprints.Preprint;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

public class PreprintViewModel extends AndroidViewModel {
    public MutableLiveData<String> authors = new MutableLiveData<>();
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> city = new MutableLiveData<>();
    public MutableLiveData<String> place = new MutableLiveData<>();
    public MutableLiveData<String> year = new MutableLiveData<>();
    public MutableLiveData<String> sheet = new MutableLiveData<>();
    public MutableLiveData<String> organisation = new MutableLiveData<>();
    public MutableLiveData<String> abbreviation = new MutableLiveData<>();

    private Application mApplication;
    private String userLogin;
    private Preprint mPreprint;

    public PreprintViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
        mPreprint = new Preprint();
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Preprint getPreprintData() {
        mPreprint.setAuthors(authors.getValue());
        mPreprint.setCity(city.getValue());
        mPreprint.setName(name.getValue());
        mPreprint.setPlace(place.getValue());
        mPreprint.setYear(year.getValue());
        mPreprint.setSheet(sheet.getValue());
        mPreprint.setOrganisation(organisation.getValue());
        mPreprint.setAbbreviation(abbreviation.getValue());
        mPreprint.setUserLogin(userLogin);

        return mPreprint;
    }

    public class NewPreprint {
        private final UserInputViewModel mPreprintInputViewModel;

        public NewPreprint() {
            mPreprintInputViewModel = new UserInputViewModel(mApplication);
        }

        public void createNewPreprint() {
            mPreprintInputViewModel.insert(getPreprintData());
        }
    }
}