package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.legislative_normative_documents.LegisNormDocuments;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

public class NormDocumentViewModel extends AndroidViewModel {
    public MutableLiveData<String> type = new MutableLiveData<>();
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> dateAccess = new MutableLiveData<>();
    public MutableLiveData<String> datePublish = new MutableLiveData<>();
    public MutableLiveData<String> number = new MutableLiveData<>();
    public MutableLiveData<String> serial = new MutableLiveData<>();
    public MutableLiveData<String> sheets = new MutableLiveData<>();
    public MutableLiveData<String> publish = new MutableLiveData<>();

    private Application mApplication;
    private String userLogin;
    private LegisNormDocuments mLegisNormDocuments;

    public NormDocumentViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
        mLegisNormDocuments = new LegisNormDocuments();
    }

    public void setValues(LegisNormDocuments legisNormDocuments) {
        type.setValue(legisNormDocuments.getType());
        name.setValue(legisNormDocuments.getName());
        dateAccess.setValue(legisNormDocuments.getDateAccess());
        datePublish.setValue(legisNormDocuments.getDateAccess());
        number.setValue(legisNormDocuments.getNumber());
        serial.setValue(legisNormDocuments.getSerial());
        sheets.setValue(legisNormDocuments.getSheets());
        publish.setValue(legisNormDocuments.getPublish());
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public LegisNormDocuments getLegisNormDocuments() {
        mLegisNormDocuments.setPublish(publish.getValue());
        mLegisNormDocuments.setSheets(sheets.getValue());
        mLegisNormDocuments.setSerial(serial.getValue());
        mLegisNormDocuments.setNumber(number.getValue());
        mLegisNormDocuments.setDatePublish(datePublish.getValue());
        mLegisNormDocuments.setDateAccess(dateAccess.getValue());
        mLegisNormDocuments.setName(name.getValue());
        mLegisNormDocuments.setType(type.getValue());
        mLegisNormDocuments.setUserLogin(userLogin);

        return mLegisNormDocuments;
    }

    public class NewLegisNormDocuments {
        private final UserInputViewModel mLegisNormDocumentsInputViewModel;

        public NewLegisNormDocuments() {
            mLegisNormDocumentsInputViewModel = new UserInputViewModel(mApplication);
        }

        public boolean createNewLegisNormDocuments() {
           return mLegisNormDocumentsInputViewModel.insert(getLegisNormDocuments());
        }
    }
}