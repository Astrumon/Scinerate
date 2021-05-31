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
import com.kpi.scineticle.model.subsystemOfDataBase.thesis.ThesisRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.user.User;
import com.kpi.scineticle.model.subsystemOfDataBase.user.UserRepository;
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
    }

    public void update(User user) {
        mUserRepository.update(user);
    }

    public void update(Article article) {
        mArticleRepository.update(article);
    }

    public void update(Standart standart) {
        mStandartRepository.update(standart);
    }

    public void update(Patent patent) {
        mPatentRepository.update(patent);
    }

    public void update(BibliographicPointer bibliographicPointer) {
        mBibliographicRepository.update(bibliographicPointer);
    }

    public void update(Preprint preprint) {
        mPreprintRepository.update(preprint);
    }

    public void update(Dissertation dissertation) {
        mDissertationRepository.update(dissertation);
    }

    public void update(LegisNormDocuments legisNormDocuments) {
        mLegisNormDocumentsRepository.update(legisNormDocuments);
    }

    public void update(ElectronicResource electronicResource) {
        mElectronicResourceRepository.update(electronicResource);
    }

    public void update(Catalog catalog) {
        mCatalogRepository.update(catalog);
    }
    public void update(Book book) {
        mBookRepository.delete(book);
    }
}
