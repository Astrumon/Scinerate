package com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;
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
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.ScientWorkValidation;
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.UserFinder;
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.UserValidation;

public class UserInputViewModel extends InputViewModel<User> {


    public UserInputViewModel(@NonNull Application application) {
        mUserRepository = new UserRepository(application);
        mUserValidation = new UserValidation(application.getApplicationContext());
        mScientWorkValidation = new ScientWorkValidation(application.getApplicationContext());
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

    public boolean insert(Article article) {
        Log.d("VALID", "ArticleDataValid: " +mScientWorkValidation.ArticleDataValid(article));
        if (mScientWorkValidation.ArticleDataValid(article)) {
            article.setNewest(++ScientWork.count);
            mArticleRepository.insert(article);
            return true;
        }

        return false;
    }

    public boolean insert(BibliographicPointer bibliographicPointer) {
        if (mScientWorkValidation.BibliographicPointerDataValid(bibliographicPointer)) {
            bibliographicPointer.setNewest(++ScientWork.count);
            mBibliographicRepository.insert(bibliographicPointer);
            return true;
        }
        return false;
    }

    public boolean insert(Patent patent) {
        if(mScientWorkValidation.PatentDataValid(patent)) {
            patent.setNewest(++ScientWork.count);
            mPatentRepository.insert(patent);
            return true;
        }

        return false;
    }

    public boolean insert(Standart standart) {
        if (mScientWorkValidation.StandartDataValid(standart)){
            standart.setNewest(++ScientWork.count);
            mStandartRepository.insert(standart);
            return true;
        }

        return false;
    }

    public boolean insert(Preprint preprint) {
        if (mScientWorkValidation.PreprintDataValid(preprint)) {
            preprint.setNewest(++ScientWork.count);
            mPreprintRepository.insert(preprint);
            return true;
        }

        return false;
    }

    public boolean insert(Catalog catalog) {
       if (mScientWorkValidation.CatalogDataValid(catalog)) {
           catalog.setNewest(++ScientWork.count);
           mCatalogRepository.insert(catalog);
           return true;
       }

        return false;
    }

    public boolean insert(Thesis thesis) {
        if (mScientWorkValidation.ThesisDataValid(thesis)) {
            thesis.setNewest(++ScientWork.count);
            mThesisRepository.insert(thesis);
            return true;
        }

        return false;
    }

    public boolean insert(ElectronicResource electronicResource) {
        if (mScientWorkValidation.ElectronicResourceDataValid(electronicResource)) {
            electronicResource.setNewest(++ScientWork.count);
            mElectronicResourceRepository.insert(electronicResource);
            return true;
        }

        return false;
    }

    public boolean insert(Book book) {
        if (mScientWorkValidation.BookDataValid(book)) {
            book.setNewest(++ScientWork.count);
            mBookRepository.insert(book);
            return true;
        }

        return false;
    }

    public boolean insert(LegisNormDocuments legisNormDocuments){
       if (mScientWorkValidation.LegisNormDocumentsDataValid(legisNormDocuments)) {
           legisNormDocuments.setNewest(++ScientWork.count);
           mLegisNormDocumentsRepository.insert(legisNormDocuments);
           return true;
       }

        return false;
    }

    public boolean insert(Dissertation dissertation) {
        if (mScientWorkValidation.DissertationDataValid(dissertation)) {
            dissertation.setNewest(++ScientWork.count);
            mDissertationRepository.insert(dissertation);
            return true;
        }

        return false;
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
