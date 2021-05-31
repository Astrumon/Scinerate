package com.kpi.scineticle.viewmodel.subsystemFormationOfRules.deleteData;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.kpi.scineticle.model.subsystemOfDataBase.article.ArticleRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.bibliographic_pointers.BibliographicRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.book.BookRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.catalogs.CatalogRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.dissertations.DissertationRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.electronic_resource.ElectronicResourceRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.legislative_normative_documents.LegisNormDocumentsRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.patents.PatentRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.preprints.PreprintRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.standarts.StandartRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.thesis.ThesisRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.user.UserRepository;
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.UserFinder;
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.UserValidation;

public abstract class DeleteViewModel<T> {
    public UserRepository mUserRepository;
    public UserValidation mUserValidation;
    public UserFinder mUserFinder;
    public ArticleRepository mArticleRepository;
    public BibliographicRepository mBibliographicRepository;
    public PatentRepository mPatentRepository;
    public StandartRepository mStandartRepository;
    public BookRepository mBookRepository;
    public DissertationRepository mDissertationRepository;
    public ThesisRepository mThesisRepository;
    public ElectronicResourceRepository mElectronicResourceRepository;
    public LegisNormDocumentsRepository mLegisNormDocumentsRepository;
    public PreprintRepository mPreprintRepository;
    public CatalogRepository mCatalogRepository;
    abstract void delete(T t);
    abstract void deleteAllUsers();
}
