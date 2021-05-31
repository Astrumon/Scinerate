package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;
import com.kpi.scineticle.model.subsystemOfDataBase.article.Article;
import com.kpi.scineticle.model.subsystemOfDataBase.article.ArticleRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;
import com.kpi.scineticle.model.subsystemOfDataBase.book.BookRepository;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.deleteData.UserDeleteViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.editData.UserEditViewModel;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ScientificWorkCRUDViewModel extends AndroidViewModel {
    private UserInputViewModel mUserInputViewModel;
    private UserEditViewModel mUserEditViewModel;
    private UserDeleteViewModel mUserDeleteViewModel;
    private LiveData<List<Article>> allScientWorks;
    private String userLogin;
    private Application application;
    private MediatorLiveData<List<? extends ScientWork>> mediatorLiveData;

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }


    public ScientificWorkCRUDViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        mUserInputViewModel = new UserInputViewModel(application);
        mUserEditViewModel = new UserEditViewModel(application);
        mUserDeleteViewModel = new UserDeleteViewModel(application);
        mediatorLiveData = new MediatorLiveData<>();

        //Log.d("SCIENTWORK", "ScientificWorkCRUDViewModel: " + allScientWorks.getValue().size());
    }

    public MediatorLiveData<List<? extends ScientWork>> getMediatorLiveData() {
        return mediatorLiveData;
    }


    public MediatorLiveData<List<? extends ScientWork>> getAllScientWorks() {
        ArticleRepository mArticleRepository = new ArticleRepository(application);
        LiveData<List<Article>> articleLiveData = mArticleRepository.getAllArticlesByLogin(userLogin);

        mediatorLiveData.addSource(articleLiveData, new Observer<List<Article>>() {
            private final List<ScientWork> list = new ArrayList<>();
            @Override
            public void onChanged(List<Article> articles) {
                for (Article article : articles) {
                    list.add((ScientWork) article);
                }
                mediatorLiveData.setValue(articles);
            }
        });
        LiveData<List<Book>> bookLiveData = new BookRepository(application).getAllBooksByLogin(userLogin);

       mediatorLiveData.addSource(bookLiveData, new Observer<List<Book>>() {
            private final List<ScientWork> list = new LinkedList<>();
            @Override
            public void onChanged(List<Book> books) {
                for (Book book : books) {
                    list.add((ScientWork) book);
                }
                mediatorLiveData.setValue(books);
            }
        });


        return mediatorLiveData;
    }

    public LiveData<List<Book>> getAllTestWorks() {

        BookRepository bookRepository = new BookRepository(application);


        return bookRepository.getAllBooksByLogin(userLogin);
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
