package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;
import com.kpi.scineticle.model.subsystemOfDataBase.article.Article;
import com.kpi.scineticle.model.subsystemOfDataBase.article.ArticleRepository;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.deleteData.UserDeleteViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.editData.UserEditViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

import java.util.List;

public class ScientificWorkCRUDViewModel extends AndroidViewModel {
    private UserInputViewModel mUserInputViewModel;
    private UserEditViewModel mUserEditViewModel;
    private UserDeleteViewModel mUserDeleteViewModel;
    private LiveData<List<Article>> allScientWorks;
    private String userLogin;
    private Application application;

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }


    public ScientificWorkCRUDViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        mUserInputViewModel = new UserInputViewModel(application);
        mUserEditViewModel = new UserEditViewModel(application);
        mUserDeleteViewModel = new UserDeleteViewModel(application);

        Log.d("NEWUSER", "ScientificWorkCRUDViewModel: " + userLogin);

        //Log.d("SCIENTWORK", "ScientificWorkCRUDViewModel: " + allScientWorks.getValue().size());

    }

    public LiveData<List<Article>> getAllScientWorks() {
        ArticleRepository mArticleRepository = new ArticleRepository(application);
        allScientWorks = mArticleRepository.getAllArticlesByLogin(userLogin);
        return allScientWorks;
    }

    public UserInputViewModel getUserInputViewModel() {
        return mUserInputViewModel;
    }

    public UserEditViewModel getUserEditViewModel() {
        return mUserEditViewModel;
    }

    public UserDeleteViewModel getUserDeleteViewModel() {
        return mUserDeleteViewModel;
    }
}
