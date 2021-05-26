package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.article.Article;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

public class ArticleViewModel extends AndroidViewModel {
    public MutableLiveData<String> authors = new MutableLiveData<>();
    public MutableLiveData<String> nameArticle = new MutableLiveData<>();
    public MutableLiveData<String> nameJournal = new MutableLiveData<>();
    public MutableLiveData<String> date = new MutableLiveData<>();
    public MutableLiveData<String> number = new MutableLiveData<>();
    public MutableLiveData<String> sheets = new MutableLiveData<>();

    private String userLogin;

    private Application mApplication;
    private final Article mArticle;

    public String getIdUser() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public ArticleViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
        mArticle = new Article();
    }

    public Article getArticleData(){
        mArticle.setUserLogin(userLogin);
        mArticle.setAuthors(authors.getValue());
        mArticle.setNameArticle(nameArticle.getValue());
        mArticle.setNameJournal(nameJournal.getValue());
        mArticle.setDate(date.getValue());
        mArticle.setNumber(number.getValue());
        mArticle.setSheets(sheets.getValue());

        return mArticle;
    }

    public class NewArticle {
        private final UserInputViewModel mArticleInputViewModel;

        public NewArticle() {
            mArticleInputViewModel = new UserInputViewModel(mApplication);
        }

        public void createNewArticle() {
            mArticleInputViewModel.insert(getArticleData());
        }
    }

}