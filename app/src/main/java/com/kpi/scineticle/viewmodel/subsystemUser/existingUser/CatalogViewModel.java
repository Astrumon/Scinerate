package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.catalogs.Catalog;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

public class CatalogViewModel extends AndroidViewModel {
    public MutableLiveData<String> authors = new MutableLiveData<>();
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> publish = new MutableLiveData<>();
    public MutableLiveData<String> city = new MutableLiveData<>();
    public MutableLiveData<String> year = new MutableLiveData<>();
    public MutableLiveData<String> sheet = new MutableLiveData<>();
    public MutableLiveData<String> place = new MutableLiveData<>();
    public MutableLiveData<String> organisation = new MutableLiveData<>();
    public MutableLiveData<String> abbreviation = new MutableLiveData<>();

    private Application mApplication;
    private String userLogin;
    private Catalog mCatalog;

    public CatalogViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
        mCatalog = new Catalog();
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Catalog getCatalog() {
        mCatalog.setPublish(publish.getValue());
        mCatalog.setAuthors(authors.getValue());
        mCatalog.setPlace(place.getValue());
        mCatalog.setSheet(sheet.getValue());
        mCatalog.setCity(city.getValue());
        mCatalog.setYear(year.getValue());
        mCatalog.setName(name.getValue());
        mCatalog.setOrganisation(organisation.getValue());
        mCatalog.setAbbreviation(abbreviation.getValue());
        mCatalog.setUserLogin(userLogin);

        return mCatalog;
    }

    public class NewCatalog {
        private final UserInputViewModel mCatalogInputViewModel;

        public NewCatalog() {
            mCatalogInputViewModel = new UserInputViewModel(mApplication);
        }

        public void createNewCatalog() {
            mCatalogInputViewModel.insert(getCatalog());
        }
    }
}