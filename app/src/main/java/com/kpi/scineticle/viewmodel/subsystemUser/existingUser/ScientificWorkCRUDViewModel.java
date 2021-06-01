package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.article.Article;
import com.kpi.scineticle.model.subsystemOfDataBase.article.ArticleRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.bibliographic_pointers.BibliographicPointer;
import com.kpi.scineticle.model.subsystemOfDataBase.bibliographic_pointers.BibliographicRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;
import com.kpi.scineticle.model.subsystemOfDataBase.book.BookRepository;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.deleteData.UserDeleteViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.editData.UserEditViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

import java.util.List;

public class ScientificWorkCRUDViewModel extends AndroidViewModel {
    private UserInputViewModel mUserInputViewModel;
    private UserEditViewModel mUserEditViewModel;
    private UserDeleteViewModel mUserDeleteViewModel;
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
    }

    public LiveData<List<Book>> getAllTestWorks() {
        return new BookRepository(application).getAllBooksByLogin(userLogin);
    }

    public LiveData<List<Article>> getAllArticle() {
        return new ArticleRepository(application).getAllArticlesByLogin(userLogin);
    }

    public LiveData<List<BibliographicPointer>> getAllBibliographicPointers() {
        return new BibliographicRepository(application).getAllBibliographicPointersByLogin(userLogin);
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
