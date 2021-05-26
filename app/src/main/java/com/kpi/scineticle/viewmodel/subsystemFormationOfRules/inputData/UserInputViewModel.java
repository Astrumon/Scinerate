package com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

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
import com.kpi.scineticle.model.subsystemOfDataBase.user.User;
import com.kpi.scineticle.model.subsystemOfDataBase.user.UserRepository;
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.UserFinder;
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.UserValidation;

public class UserInputViewModel extends InputViewModel<User> {

    private final UserRepository mUserRepository;
    private UserValidation mUserValidation;
    private UserFinder mUserFinder;
    private ArticleRepository mArticleRepository;
    private BibliographicRepository mBibliographicRepository;
    private PatentRepository mPatentRepository;
    private StandartRepository mStandartRepository;
    private BookRepository mBookRepository;
    private DissertationRepository mDissertationRepository;
    private ThesisRepository mThesisRepository;
    private ElectronicResourceRepository mElectronicResourceRepository;
    private LegisNormDocumentsRepository mLegisNormDocumentsRepository;
    private PreprintRepository mPreprintRepository;
    private CatalogRepository mCatalogRepository;


    public UserInputViewModel(@NonNull Application application) {
        mUserRepository = new UserRepository(application);
        mUserValidation = new UserValidation(application.getApplicationContext());
        mUserFinder = new UserFinder(application.getApplicationContext(), mUserRepository);
        mArticleRepository = new ArticleRepository(application);
        mBibliographicRepository = new BibliographicRepository(application);
        mPatentRepository = new PatentRepository(application);
        mStandartRepository = new StandartRepository(application);
        mBookRepository = new BookRepository(application);
        mDissertationRepository = new DissertationRepository(application);
        mThesisRepository = new ThesisRepository(application);
        mElectronicResourceRepository = new ElectronicResourceRepository(application);
        mLegisNormDocumentsRepository = new LegisNormDocumentsRepository(application);
        mPreprintRepository = new PreprintRepository(application);
        mCatalogRepository = new CatalogRepository(application);
    }

    @Override
    public boolean insert(User user) {
        if (mUserValidation.UserDataValid(user) && !checkExistingMail(user)) {
            mUserRepository.insert(user);
            return true;
        }
        return false;
    }

    public void insert(Article article) {
        mArticleRepository.insert(article);
    }

    public void insert(BibliographicPointer bibliographicPointer) {
        mBibliographicRepository.insert(bibliographicPointer);
    }

    public void insert(Patent patent) {
        mPatentRepository.insert(patent);
    }

    public void insert(Standart standart) {
        mStandartRepository.insert(standart);
    }

    public void insert(Preprint preprint) {
        mPreprintRepository.insert(preprint);
    }

    public void insert(Catalog catalog) {
        mCatalogRepository.insert(catalog);
    }

    public void insert(Thesis thesis) {
        mThesisRepository.insert(thesis);
    }

    public void insert(ElectronicResource electronicResource) {
        mElectronicResourceRepository.insert(electronicResource);
    }

    public void insert(Book book) {
        mBookRepository.insert(book);
    }

    public void insert(LegisNormDocuments legisNormDocuments){
        mLegisNormDocumentsRepository.insert(legisNormDocuments);
    }

    public void insert(Dissertation dissertation) {
        mDissertationRepository.insert(dissertation);
    }

    public boolean inputDataForCheck(String email, String password) {
        Log.d("UserInputDataForCheck", "email: " + email + ", password: " + password);
        boolean result = false;
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        if (mUserValidation.isValidEmail(user) && mUserValidation.isValidPassword(user)) {
            result = mUserFinder.existUserFromDB(user);
        }
        return  result;
    }

    public boolean checkExistingMail(User user)  {
        Log.d("UserInputDataForCheck", "email: " + user);
        boolean result = false;


        if (mUserValidation.isValidEmail(user)) {
            result = mUserFinder.isExistUserForRegistration(user);
        }
        return result;

    }


}
