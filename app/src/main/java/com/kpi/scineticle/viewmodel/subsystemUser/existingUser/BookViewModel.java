package com.kpi.scineticle.viewmodel.subsystemUser.existingUser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;
import com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData.UserInputViewModel;

public class BookViewModel extends AndroidViewModel {
    public MutableLiveData<String> authors = new MutableLiveData<>();
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> publish = new MutableLiveData<>();
    public MutableLiveData<String> statement = new MutableLiveData<>();
    public MutableLiveData<String> year = new MutableLiveData<>();
    public MutableLiveData<String> part = new MutableLiveData<>();
    public MutableLiveData<String> place = new MutableLiveData<>();
    public MutableLiveData<String> countOfSheets = new MutableLiveData<>();

    private Application mApplication;
    private String userLogin;
    private Book mBook;

    public BookViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
        mBook = new Book();
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Book getBook() {
        mBook.setPublish(publish.getValue());
        mBook.setAuthors(authors.getValue());
        mBook.setPlace(place.getValue());
        mBook.setPart(part.getValue());
        mBook.setStatement(statement.getValue());
        mBook.setYear(year.getValue());
        mBook.setName(name.getValue());
        mBook.setCountOfSheets(countOfSheets.getValue());
        mBook.setUserLogin(userLogin);

        return mBook;
    }

    public class NewBook {
        private final UserInputViewModel mBookInputViewModel;

        public NewBook() {
            mBookInputViewModel = new UserInputViewModel(mApplication);
        }

        public void createNewBook() {
            mBookInputViewModel.insert(getBook());
        }
    }
}