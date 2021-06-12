package com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions;

import android.content.Context;

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

    public ScientWorkValidation(Context context) {
        mUserOutputInfo = new UserOutputInfo(context);
    }

    public boolean ArticleDataValid(Article article) {
        if (article == null) {
            return false;
        }

        if (!article.isValidAuthors()) {
            mUserOutputInfo.showError("Некоректно ведена інформація про автора");
            return false;
        }

        if (!article.isValidNameArticle()) {
            mUserOutputInfo.showError("Некоректно ведена назва статті");
            return false;
        }

        if(!article.isValidNameJournal()) {
            mUserOutputInfo.showError("Некоректно веденеа назва журналу");
            return false;
        }

        if (!article.isValidDate()) {
            mUserOutputInfo.showError("Некоректний формат дати");
            return false;
        }

        if (!article.isValidNumber()) {
            mUserOutputInfo.showError("Некоректно ведений номер");
            return false;
        }

        if (!article.isValidSheet()) {
            mUserOutputInfo.showError("Некоректно ведений сторінковий інтервал");
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
            mUserOutputInfo.showError("Некоректно ведена інформація про автора редакції");
            return false;
        }

        if (!bibliographicPointer.isValidAuthorsRelease()) {
            mUserOutputInfo.showError("Некоректно ведена інформація про автора публікації");
            return false;
        }

        if (!bibliographicPointer.isValidCity()) {
            mUserOutputInfo.showError("Некоректно ведена інформація про автора публікації");
            return false;
        }

        if (!bibliographicPointer.isValidNumberOfRelease()) {
            mUserOutputInfo.showError("Некоректно ведена інформація про номер випуску");
            return false;
        }

        if (!bibliographicPointer.isValidPlace()) {
            mUserOutputInfo.showError("Некоректно ведена інформація про місце");
            return false;
        }

        if (!bibliographicPointer.isValidYear()) {
            mUserOutputInfo.showError("Некоректно ведений рік");
            return false;
        }

        if (!bibliographicPointer.isValidSheet()) {
            mUserOutputInfo.showError("Некоректно ведений сторінковий інтервал");
            return false;
        }

        if (!bibliographicPointer.isValidAbbreviation()) {
            mUserOutputInfo.showError("Некоректно ведена абревіатура");
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
            mUserOutputInfo.showError("Некоректно ведена інформація про автора");
            return false;
        }

        if (!book.isValidName()){
            mUserOutputInfo.showError("Некоректна назва");
            return false;
        }

        if (!book.isValidStatement()){
            mUserOutputInfo.showError("Некоректний тип");
            return false;
        }

        if (!book.isValidPlace()){
            mUserOutputInfo.showError("Некоректна назва місця видавництва");
            return false;
        }

        if (!book.isValidPublish()) {
            mUserOutputInfo.showError("Некоректна назва видавництва");
            return false;
        }

        if (!book.isValidYear()){
            mUserOutputInfo.showError("Некоректний рік");
            return false;
        }

        if (!book.isValidSheet()){
            mUserOutputInfo.showError("Некоректно ведений сторінковий інтервал");
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
            mUserOutputInfo.showError("Некоректно ведена інформація про автора");
            return false;
        }

        if (!catalog.isValidName()){
            mUserOutputInfo.showError("Некоректно ведена назва");
            return false;
        }

        if (!catalog.isValidCity()){
            mUserOutputInfo.showError("Некоректна назва міста");
            return false;
        }

        if (!catalog.isValidPublish()){
            mUserOutputInfo.showError("Некоректна назва видавництва");
            return false;
        }

        if (!catalog.isValidPlace()){
            mUserOutputInfo.showError("Некоректна назва місця публікації");
            return false;
        }

        if (!catalog.isValidYear()){
            mUserOutputInfo.showError("Некоректний рік");
            return false;
        }

        if (!catalog.isValidSheet()){
            mUserOutputInfo.showError("Некоректно ведений сторінковий інтервал");
            return false;
        }

        if (!catalog.isValidOrganisation()){
            mUserOutputInfo.showError("Некоректна назва організації");
            return false;
        }

        if (!catalog.isValidAbbreviation()) {
            mUserOutputInfo.showError("Некоректна аббревіатура");
        }

        return true;
    }

    public boolean DissertationDataValid(Dissertation dissertation) {
        if (dissertation == null) {
            mUserOutputInfo.showError("Заповніть всі поля");
            return false;
        }

        if (!dissertation.isValidAuthors()){
            mUserOutputInfo.showError("Некоректно ведена інформація про автора");
            return false;
        }

        if (!dissertation.isValidName()){
            mUserOutputInfo.showError("Некоректно ведена назва");

            return false;
        }

        if (!dissertation.isValidType()){
            mUserOutputInfo.showError("Некоректно ведений тип роботи");
            return false;
        }

        if (!dissertation.isValidPlace()){
            mUserOutputInfo.showError("Некоректна назва місця публікації");
            return false;
        }

        if (!dissertation.isValidPublish()){
            mUserOutputInfo.showError("Некоректна назва видавництва");
            return false;
        }

        if (!dissertation.isValidYear()){
            mUserOutputInfo.showError("Некоректний рік");
            return false;
        }

        if (!dissertation.isValidSheet()){
            mUserOutputInfo.showError("Некоректно ведений сторінковий інтервал");
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
            mUserOutputInfo.showError("Некоректно ведена інформація про автора");
            return false;
        }

        if (!electronicResource.isValidName()){
            mUserOutputInfo.showError("Некоректно ведена назва");
            return false;
        }

        if (!electronicResource.isValidPlacePublish()){
            mUserOutputInfo.showError("Некоректна назва місця публікації");
            return false;
        }

        if (!electronicResource.isValidPublish()){
            mUserOutputInfo.showError("Некоректна назва видавництва");
            return false;
        }

        if (!electronicResource.isValidDate()){
            mUserOutputInfo.showError("Некоректний формат дати");
            return false;
        }

        if (!electronicResource.isValidURL()){
            mUserOutputInfo.showError("Некоректне посилання на сайт");
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
            mUserOutputInfo.showError("Некоректно ведена інформація про автора");
            return false;
        }

        if (!patent.isValidNamePatentOwner()) {
            mUserOutputInfo.showError("Некоректна назва власника патенту");
            return false;
        }

        if (!patent.isValidCountry()) {
            mUserOutputInfo.showError("Некоректна назва країни");
            return false;
        }

        if (!patent.isValidNumber()) {
            mUserOutputInfo.showError("Некоректний номер");
            return false;
        }

        if (!patent.isValidDate()) {
            mUserOutputInfo.showError("Некоректна дата");
            return false;
        }

        if (!patent.isValidName()) {
            mUserOutputInfo.showError("Некоректна назва патенту");
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
            mUserOutputInfo.showError("Некоректно ведена інформація про автора");
            return false;
        }

        if (!preprint.isValidName()) {
            mUserOutputInfo.showError("Некоректна назва патенту");
            return false;
        }

        if (!preprint.isValidCity()){
            mUserOutputInfo.showError("Некоректна назва міста");
            return false;
        }

        if (!preprint.isValidPlace()){
            mUserOutputInfo.showError("Некоректна назва місця публікації");
            return false;
        }

        if (!preprint.isValidYear()){
            mUserOutputInfo.showError("Некоректний рік");
            return false;
        }

        if (!preprint.isValidSheet()){
            mUserOutputInfo.showError("Некоректно ведений сторінковий інтервал");
            return false;
        }

        if (!preprint.isValidOrganisation()){
            mUserOutputInfo.showError("Некоректна назва організації");
            return false;
        }

        if (!preprint.isValidAbbreviation()) {
            mUserOutputInfo.showError("Некоректно ведена абревіатура");
            return false;
        }

        return true;
    }

    public boolean StandartDataValid(Standart standart) {
        if (standart == null) {
            mUserOutputInfo.showError("Заповніть всі поля");
            return false;
        }

        if (!standart.isValidNameOfOrg()){
            mUserOutputInfo.showError("Некоректна назва організації");
            return false;
        }

        if (!standart.isValidName()) {
            mUserOutputInfo.showError("Некоректна назва стандарту");
            return false;
        }

        if (!standart.isValidYearPublish()){
            mUserOutputInfo.showError("Некоректний рік публікації");
            return false;
        }

        if (!standart.isValidCodeLetter()) {
            mUserOutputInfo.showError("Некоректний буквенний код");
            return false;
        }

        if (!standart.isValidCodeNumber()) {
            mUserOutputInfo.showError("Некоректний числовий код");
            return false;
        }

        if (!standart.isValidPublish()) {
            mUserOutputInfo.showError("Некоректна назва видавництва");
            return false;
        }

        if (!standart.isValidPlacePublish()){
            mUserOutputInfo.showError("Некоректна назва місця публікації");
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
            mUserOutputInfo.showError("Некоректно ведена інформація про автора");
            return false;
        }

        if (!thesis.isValidName()){
            mUserOutputInfo.showError("Некоректно ведена назва тезису");
            return false;
        }

        if (!thesis.isValidNameConference()) {
            mUserOutputInfo.showError("Некоректна назва конференції");
            return false;
        }

        if (!thesis.isValidDate()) {
            mUserOutputInfo.showError("Некоректний формат дати");
            return false;
        }

        if (!thesis.isValidPlaceConferenece()) {
            mUserOutputInfo.showError("Некоректна назва місця проведення конференції");
            return false;
        }

        if (!thesis.isValidPlacePublish()) {
            mUserOutputInfo.showError("Некоректна назва місця публікації");
            return false;
        }

        if (!thesis.isValidYear()) {
            mUserOutputInfo.showError("Некоректний рік");
            return false;
        }

        if (!thesis.isValidSheet()) {
            mUserOutputInfo.showError("Некоректний сторінковий інтервал");
            return false;
        }

        return true;

    }

    public boolean LegisNormDocumentsDataValid(LegisNormDocuments legisNormDocuments) {
        if (legisNormDocuments == null) {
            mUserOutputInfo.showError("Заповніть всі поля");
            return  false;
        }

        if (!legisNormDocuments.isValidName()){
            mUserOutputInfo.showError("Некоректно ведена назва");
            return false;
        }

        if (!legisNormDocuments.isValidType()) {
            mUserOutputInfo.showError("Некоректний тип");
            return false;
        }

        if (!legisNormDocuments.isValidDateAccess()) {
            mUserOutputInfo.showError("Некоректний формат дати прийняття документу");
            return false;
        }

        if (!legisNormDocuments.isValidDatePublish()) {
            mUserOutputInfo.showError("Некоректний формат дати публікації документу");
            return false;
        }

        if (!legisNormDocuments.isValidNumber()) {
            mUserOutputInfo.showError("Некоректний номер");
            return false;
        }

        if (!legisNormDocuments.isValidNumberOfSerial()) {
            mUserOutputInfo.showError("Некоректний номер серії");
            return false;
        }

        if (!legisNormDocuments.isValidPublish()) {
            mUserOutputInfo.showError("Некоректна назва видавництва");
            return false;
        }

        if (!legisNormDocuments.isValidSheets()) {
            mUserOutputInfo.showError("Некоректно ведений сторінковий інтервал");
            return  false;
        }


        return true;

    }






}
