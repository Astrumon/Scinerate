package com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;
import com.kpi.scineticle.model.subsystemOfDataBase.article.Article;
import com.kpi.scineticle.model.subsystemOfDataBase.bibliographic_pointers.BibliographicPointer;
import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;
import com.kpi.scineticle.model.subsystemOfDataBase.catalogs.Catalog;
import com.kpi.scineticle.model.subsystemOfDataBase.dissertations.Dissertation;
import com.kpi.scineticle.model.subsystemOfDataBase.electronic_resource.ElectronicResource;
import com.kpi.scineticle.model.subsystemOfDataBase.legislative_normative_documents.LegisNormDocuments;
import com.kpi.scineticle.model.subsystemOfDataBase.patents.Patent;
import com.kpi.scineticle.model.subsystemOfDataBase.preprints.Preprint;
import com.kpi.scineticle.model.subsystemOfDataBase.standarts.Standart;
import com.kpi.scineticle.model.subsystemOfDataBase.thesis.Thesis;
import com.kpi.scineticle.viewmodel.subsystemOutputData.UserOutputInfo;

public class ScientWorkValidation {
    private UserOutputInfo mUserOutputInfo;
    private Context mContext;

    public ScientWorkValidation(Context context) {
        mContext = context;
        mUserOutputInfo = new UserOutputInfo(context);
    }

    public boolean ArticleDataValid(Article article) {
        if (article == null) {
            return false;
        }

        if (!article.isValidAuthors()) {
            mUserOutputInfo.showError("Невірно ведена інформація про автора");
            return false;
        }

        return true;
    }

    public boolean BibliographicPointerDataValid(BibliographicPointer bibliographicPointer) {
        if (bibliographicPointer == null) {
            mUserOutputInfo.showError("Заповніть всі поля");
            return false;
        }

        if (!bibliographicPointer.isValidAuthorsPublish()) {
            mUserOutputInfo.showError("Невірно ведена інформація про автора редакції");
            return false;
        }

        if (!bibliographicPointer.isValidAuthorsRelease()) {
            mUserOutputInfo.showError("Невірно ведена інформація про автора публікації");
            return false;
        }

        return true;
    }

    public boolean BookDataValid(Book book) {
        if (book == null) {
            mUserOutputInfo.showError("Заповніть всі поля");
            return false;
        }

        if (!book.isValidAuthors()){
            mUserOutputInfo.showError("Невірно ведена інформація про автора");
            return false;
        }

        return true;
    }

    public boolean CatalogDataValid(Catalog catalog) {
        if (catalog == null) {
            mUserOutputInfo.showError("Заповніть всі поля");
            return false;
        }

        if (!catalog.isValidAuthors()){
            mUserOutputInfo.showError("Невірно ведена інформація про автора");
            return false;
        }

        return true;
    }

    public boolean DissertationDataValid(Dissertation dissertation) {
        if (dissertation == null) {
            mUserOutputInfo.showError("Заповніть всі поля");
            return false;
        }

        if (!dissertation.isValidAuthors()){
            mUserOutputInfo.showError("Невірно ведена інформація про автора");
            return false;
        }

        return true;
    }

    public boolean ElectronicResourceDataValid(ElectronicResource electronicResource) {
        if (electronicResource == null) {
            mUserOutputInfo.showError("Заповніть всі поля");
            return false;
        }

        if (!electronicResource.isValidAuthors()){
            mUserOutputInfo.showError("Невірно ведена інформація про автора");
            return false;
        }

        return true;
    }

    public boolean PatentDataValid(Patent patent) {
        if (patent == null) {
            mUserOutputInfo.showError("Заповніть всі поля");
            return false;
        }

        if (!patent.isValidAuthors()){
            mUserOutputInfo.showError("Невірно ведена інформація про автора");
            return false;
        }

        return true;
    }

    public boolean PreprintDataValid(Preprint preprint) {
        if (preprint == null) {
            mUserOutputInfo.showError("Заповніть всі поля");
            return false;
        }

        if (!preprint.isValidAuthors()){
            mUserOutputInfo.showError("Невірно ведена інформація про автора");
            return false;
        }

        return true;
    }

    public boolean StandartDataValid(Standart standart) {
        if (standart == null) {
            mUserOutputInfo.showError("Заповніть всі поля");
            return false;
        }


        return true;
    }

    public boolean ThesisDataValid(Thesis thesis) {
        if (thesis == null) {
            mUserOutputInfo.showError("Заповніть всі поля");
            return  false;
        }
        if (!thesis.isValidAuthors()){
            mUserOutputInfo.showError("Невірно ведена інформація про автора");
            return false;
        }

        return true;

    }

    public boolean LegisNormDocumentsDataValid(LegisNormDocuments legisNormDocuments) {
        if (legisNormDocuments == null) {
            mUserOutputInfo.showError("Заповніть всі поля");
            return  false;
        }

        return true;

    }






}
