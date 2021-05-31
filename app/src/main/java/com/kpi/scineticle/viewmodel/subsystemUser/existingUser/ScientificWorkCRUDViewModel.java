package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;
import com.kpi.scineticle.model.subsystemOfDataBase.article.Article;
import com.kpi.scineticle.model.subsystemOfDataBase.article.ArticleRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.book.BookRepository;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.deleteData.UserDeleteViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.editData.UserEditViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

import java.util.ArrayList;
import java.util.LinkedList;
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



        //Log.d("SCIENTWORK", "ScientificWorkCRUDViewModel: " + allScientWorks.getValue().size());

    }

    public LiveData<List<Article>> getAllScientWorks() {
        Log.d("NEWUSER", "LOGIN: " + userLogin);
        ArticleRepository mArticleRepository = new ArticleRepository(application);
        BookRepository bookRepository = new BookRepository(application);
        //List<ScientWork> lists = new ArrayList<>();
        //lists.add(new Article());
       // lists.addAll(mArticleRepository.getAllArticlesByLogin(userLogin).getValue());
        //lists.addAll(bookRepository.getAllBooksByLogin(userLogin).getValue());

       // list.addAll(bookRepository.getAllBooksByLogin(userLogin).getValue());


        return mArticleRepository.getAllArticlesByLogin(userLogin);
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
