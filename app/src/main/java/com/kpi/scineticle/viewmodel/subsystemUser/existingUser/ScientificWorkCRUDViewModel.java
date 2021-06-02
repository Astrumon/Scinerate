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
import com.kpi.scineticle.model.subsystemOfDataBase.catalogs.Catalog;
import com.kpi.scineticle.model.subsystemOfDataBase.catalogs.CatalogRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.dissertations.Dissertation;
import com.kpi.scineticle.model.subsystemOfDataBase.dissertations.DissertationRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.electronic_resource.ElectronicResource;
import com.kpi.scineticle.model.subsystemOfDataBase.electronic_resource.ElectronicResourceRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.legislative_normative_documents.LegisNormDocuments;
import com.kpi.scineticle.model.subsystemOfDataBase.legislative_normative_documents.LegisNormDocumentsRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.patents.Patent;
import com.kpi.scineticle.model.subsystemOfDataBase.patents.PatentRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.preprints.Preprint;
import com.kpi.scineticle.model.subsystemOfDataBase.preprints.PreprintRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.standarts.Standart;
import com.kpi.scineticle.model.subsystemOfDataBase.standarts.StandartRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.thesis.Thesis;
import com.kpi.scineticle.model.subsystemOfDataBase.thesis.ThesisRepository;
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

    public LiveData<List<Catalog>> getAllCatalogs() {
        return new CatalogRepository(application).getAllBooksByLogin(userLogin);
    }

    public LiveData<List<Dissertation>> getAllDissertation() {
        return new DissertationRepository(application).getAllBooksByLogin(userLogin);
    }

    public LiveData<List<ElectronicResource>> getAllElectronicResources() {
        return new ElectronicResourceRepository(application).getAllElectronicResourcesByLogin(userLogin);
    }

    public LiveData<List<LegisNormDocuments>> getAllLegisNormDocuments() {
        return new LegisNormDocumentsRepository(application).getAllLegisNormDocumentsByLogin(userLogin);
    }

    public LiveData<List<Patent>> getAllPatents() {
        return new PatentRepository(application).getAllPatentsByLogin(userLogin);
    }

    public LiveData<List<Preprint>> getAllPreprints() {
        return new PreprintRepository(application).getAllPreprintsByLogin(userLogin);
    }

    public LiveData<List<Standart>> getAllStandarts() {
        return new StandartRepository(application).getAllStandartsByLogin(userLogin);
    }

    public LiveData<List<Thesis>> getAllTheses() {
        return new ThesisRepository(application).getAllThesisByLogin(userLogin);
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
