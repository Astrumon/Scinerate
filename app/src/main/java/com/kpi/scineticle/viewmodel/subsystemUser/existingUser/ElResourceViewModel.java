package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.electronic_resource.ElectronicResource;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

public class ElResourceViewModel extends AndroidViewModel {
    public MutableLiveData<String> authors = new MutableLiveData<>();
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> publish = new MutableLiveData<>();
    public MutableLiveData<String> placePublish = new MutableLiveData<>();
    public MutableLiveData<String> date = new MutableLiveData<>();
    public MutableLiveData<String> updateDate = new MutableLiveData<>();
    public MutableLiveData<String> url = new MutableLiveData<>();


    private Application mApplication;
    private String userLogin;
    private ElectronicResource mElectronicResource;

    public ElResourceViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
        mElectronicResource = new ElectronicResource();
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public ElectronicResource getElectronicResource() {
        mElectronicResource.setPublish(publish.getValue());
        mElectronicResource.setAuthors(authors.getValue());
        mElectronicResource.setPlacePublish(placePublish.getValue());
        mElectronicResource.setDate(date.getValue());
        mElectronicResource.setUpdateDate(updateDate.getValue());
        mElectronicResource.setUrl(url.getValue());
        mElectronicResource.setName(name.getValue());
        mElectronicResource.setUserLogin(userLogin);

        return mElectronicResource;
    }

    public class NewElectronicResource {
        private final UserInputViewModel mElectronicResourceInputViewModel;

        public NewElectronicResource() {
            mElectronicResourceInputViewModel = new UserInputViewModel(mApplication);
        }

        public void createNewElectronicResource() {
            mElectronicResourceInputViewModel.insert(getElectronicResource());
        }
    }
}