package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.bibliographic_pointers.BibliographicPointer;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

public class BibliographicPointerViewModel extends AndroidViewModel {
    private BibliographicPointer mBibliographicPointer;
    private Application mApplication;
    private String userLogin;

    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> numberOfRelease = new MutableLiveData<>();
    public MutableLiveData<String> authorOfRelease = new MutableLiveData<>();
    public MutableLiveData<String> aouthorsOfPublish = new MutableLiveData<>();
    public MutableLiveData<String> place = new MutableLiveData<>();
    public MutableLiveData<String> city = new MutableLiveData<>();
    public MutableLiveData<String> abbreviation = new MutableLiveData<>();
    public MutableLiveData<String> year = new MutableLiveData<>();
    public MutableLiveData<String> sheet = new MutableLiveData<>();
    public MutableLiveData<String> additionally = new MutableLiveData<>();

    public BibliographicPointerViewModel(@NonNull Application application) {
        super(application);
        mBibliographicPointer = new BibliographicPointer();
        mApplication = application;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public BibliographicPointer getBibliographicData() {
        mBibliographicPointer.setName(name.getValue());
        mBibliographicPointer.setNumberOfRelease(numberOfRelease.getValue());
        mBibliographicPointer.setAuthorOfRelease(authorOfRelease.getValue());
        mBibliographicPointer.setAouthorsOfPublish(aouthorsOfPublish.getValue());
        mBibliographicPointer.setPlace(place.getValue());
        mBibliographicPointer.setCity(city.getValue());
        mBibliographicPointer.setAbbreviation(abbreviation.getValue());
        mBibliographicPointer.setYear(year.getValue());
        mBibliographicPointer.setSheet(sheet.getValue());
        mBibliographicPointer.setAdditionally(additionally.getValue());
        mBibliographicPointer.setUserLogin(userLogin);

        return mBibliographicPointer;
    }

    public class NewBibliographicPointer {
        private final UserInputViewModel mBibliographicInputViewModel;

        public NewBibliographicPointer() {
            mBibliographicInputViewModel = new UserInputViewModel(mApplication);
        }

        public void createNewBibliographicPointer() {
            mBibliographicInputViewModel.insert(getBibliographicData());
        }
    }
}