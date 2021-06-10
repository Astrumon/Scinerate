package com.kpi.scineticle.viewmodel.subsystemFormationOfRules.deleteData;

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


public class UserDeleteViewModel extends DeleteViewModel<User> {

    public UserDeleteViewModel(@NonNull Application application) {
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

    public void delete(User user) {
        mUserRepository.update(user);
    }

    public void delete(Article article) {
        mArticleRepository.delete(article);
    }

    public void delete(Standart standart) {
        mStandartRepository.delete(standart);
    }

    public void delete(Patent patent) {
        mPatentRepository.delete(patent);
    }

    public void delete(BibliographicPointer bibliographicPointer) {
        mBibliographicRepository.delete(bibliographicPointer);
    }

    public void delete(Preprint preprint) {
        mPreprintRepository.delete(preprint);
    }

    public void delete(Dissertation dissertation) {
        mDissertationRepository.delete(dissertation);
    }

    public void delete(LegisNormDocuments legisNormDocuments) {
        mLegisNormDocumentsRepository.delete(legisNormDocuments);
    }

    public void delete(ElectronicResource electronicResource) {
        mElectronicResourceRepository.delete(electronicResource);
    }

    public void delete(Catalog catalog) {
        mCatalogRepository.delete(catalog);
    }

    public void delete(Book book) {
        mBookRepository.delete(book);
    }


    public void deleteAllUsers() {
        mUserRepository.deleteAllUsers();
    }

    public void deleteAllCatalogs() {
        mCatalogRepository.deleteAllCatalogs();
    }

    public void deleteAllStandarts() {
        mStandartRepository.deleteAllStandarts();
    }

    public void deleteAllPreprints() {
        mPreprintRepository.deleteAllPreprints();
    }

    public void deleteAllPatents() {
        mPatentRepository.deleteAllPatents();
    }

    public void deleteAllBibliographicPointers() {
        mBibliographicRepository.deleteAllBibliographicPointers();
    }

    public void deleteAllArticles() {
        mArticleRepository.deleteAllArticles();
    }

    public void deleteAllDissertation() {
        mDissertationRepository.deleteAllDissertations();
    }

    public void deleteAllThesis() {
        mThesisRepository.deleteAllThesis();
    }

    public void deleteAllLegisNormDocuments() {
        mLegisNormDocumentsRepository.deleteAllLegisNormDocuments();
    }

    public void deleteAllElResources() {
        mElectronicResourceRepository.deleteAllElectronicResources();
    }

    public void deleteAllBooks() {
        mBookRepository.deleteAllBooks();
    }

    public void deleteAllWorks() {
        deleteAllArticles();
        deleteAllBooks();
        deleteAllCatalogs();
        deleteAllBibliographicPointers();
        deleteAllDissertation();
        deleteAllElResources();
        deleteAllPatents();
        deleteAllPreprints();
        deleteAllThesis();
        deleteAllLegisNormDocuments();
        deleteAllStandarts();
    }
}
