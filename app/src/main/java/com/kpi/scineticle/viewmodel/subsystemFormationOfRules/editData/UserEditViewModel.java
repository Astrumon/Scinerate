package com.kpi.scineticle.viewmodel.subsystemFormationOfRules.editData;

import android.app.Application;

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
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.ScientWorkValidation;
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.UserFinder;
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.UserValidation;

public class UserEditViewModel extends EditViewModel<User> {

    public UserEditViewModel(@NonNull Application application) {
        mUserRepository = new UserRepository(application);
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
        mScientWorkValidation = new ScientWorkValidation(application);
    }

    public void update(User user) {
        mUserRepository.update(user);
    }

    public boolean update(Article article) {
        if (mScientWorkValidation.ArticleDataValid(article)) {
            mArticleRepository.update(article);
            return true;
        } else  {
            return false;
        }
    }

    public boolean update(Standart standart) {
        if (mScientWorkValidation.StandartDataValid(standart)){
            mStandartRepository.update(standart);
            return true;
        }

        return false;
    }

    public boolean update(Patent patent) {
        if(mScientWorkValidation.PatentDataValid(patent)) {
            mPatentRepository.update(patent);
            return true;
        }

        return false;
    }

    public boolean update(BibliographicPointer bibliographicPointer) {
        if (mScientWorkValidation.BibliographicPointerDataValid(bibliographicPointer)) {
            mBibliographicRepository.update(bibliographicPointer);
            return true;
        }
        return false;
    }

    public boolean update(Preprint preprint) {
        if (mScientWorkValidation.PreprintDataValid(preprint)) {
            mPreprintRepository.update(preprint);
            return true;
        }

        return false;
    }

    public boolean update(Dissertation dissertation) {
        if (mScientWorkValidation.DissertationDataValid(dissertation)) {
            mDissertationRepository.update(dissertation);
            return true;
        }

        return false;
    }

    public boolean update(LegisNormDocuments legisNormDocuments){
        if (mScientWorkValidation.LegisNormDocumentsDataValid(legisNormDocuments)) {
            mLegisNormDocumentsRepository.update(legisNormDocuments);
            return true;
        }

        return false;
    }

    public boolean update(ElectronicResource electronicResource) {
        if (mScientWorkValidation.ElectronicResourceDataValid(electronicResource)) {
            mElectronicResourceRepository.update(electronicResource);
            return true;
        }

        return false;
    }

    public boolean update(Catalog catalog) {
        if (mScientWorkValidation.CatalogDataValid(catalog)) {
            mCatalogRepository.update(catalog);
            return true;
        }

        return false;
    }

    public boolean update(Book book) {
        if (mScientWorkValidation.BookDataValid(book)) {
            mBookRepository.update(book);
            return true;
        }

        return false;
    }

    public boolean update(Thesis thesis) {
        if (mScientWorkValidation.ThesisDataValid(thesis)) {
            mThesisRepository.update(thesis);
            return true;
        }

        return false;
    }
}
