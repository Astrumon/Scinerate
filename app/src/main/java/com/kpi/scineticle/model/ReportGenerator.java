package com.kpi.scineticle.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

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

import java.util.List;

public class ReportGenerator {
    private String report;
    private Object work;
    private List<Data> mAllData;

    private void generate() {
        if (work instanceof Article) {
            report = getArticleReport((Article) work);
        }

        if (work instanceof Book) {
            report = getBookReport((Book)work);
        }

        if (work instanceof BibliographicPointer) {
            report = getBibliographicPointerReport((BibliographicPointer) work);
        }

        if (work instanceof Catalog) {
            report = getCatalogReport((Catalog) work);
        }

        if (work instanceof Dissertation) {
            report = getDissertationReport((Dissertation) work);
        }

        if (work instanceof ElectronicResource) {
            report = getElectronicResourceReport((ElectronicResource) work);
        }

        if (work instanceof LegisNormDocuments) {
            report = getLegislativeNormativeDocumentsReport((LegisNormDocuments) work);
        }

        if (work instanceof Patent) {
            report = getPatentReport((Patent) work);
        }

        if (work instanceof Preprint) {
            report = getPreprintReport((Preprint) work);
        }

        if (work instanceof Standart) {
            report = getStandartReport((Standart) work);
        }

        if (work instanceof Thesis) {
            report = getThesisReport((Thesis) work);
        }

    }

    private String generate(Data work) {
        switch (work.type) {
            case Data.ARTICLE:
                return getArticleReport(work.article);
            case Data.BOOK:
                return getBookReport(work.book);
            case Data.BIBLIOGRAPHIC_POINTER:
                return getBibliographicPointerReport(work.bibliographicPointer);
            case Data.CATALOG:
                return getCatalogReport(work.catalog);
            case Data.DISSERTATION:
                return getDissertationReport(work.dissertation);
            case Data.ELECTRONIC_RESOURCE:
                return getElectronicResourceReport(work.electronicResource);
            case Data.LEGIS_NORM_DOCUMENTS:
                return getLegislativeNormativeDocumentsReport(work.legisNormDocuments);
            case Data.PATENT:
                return getPatentReport(work.patent);
            case Data.PREPRINT:
                return getPreprintReport(work.preprint);
            case Data.STANDART:
                return getStandartReport(work.standart);
            case Data.THESIS:
                return getThesisReport(work.thesis);
            default:
                return "NO WORK";
        }



    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String generateAll() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Data data : mAllData) {
            stringBuilder
                    .append(++i)
                    .append(") ")
                    .append(generate(data))
                    .append(System.lineSeparator())
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }

    public String getArticleReport(Article article) {
        return article.getAuthors()
                + "."
                + article.getNameArticle()
                + "."
                + article.getNameJournal()
                + "."
                + article.getDate()
                + ";"
                + article.getNumber()
                + ":"
                + article.getSheets() + ".";
    }

    public String getBibliographicPointerReport(BibliographicPointer bibliographicPointer) {
        return bibliographicPointer.getName()
                + " : бібліогр. покажч. Вип. "
                + bibliographicPointer.getNumberOfRelease()
                + "/уклад.:"
                + bibliographicPointer.getAouthorsOfPublish()
                + ", відп. за вип. "
                + bibliographicPointer.getAuthorOfRelease()
                + " ; "
                + bibliographicPointer.getPlace()
                + "."
                + bibliographicPointer.getCity()
                + " : "
                + bibliographicPointer.getAbbreviation()
                + ", "
                + bibliographicPointer.getYear()
                + ". "
                + bibliographicPointer.getSheet()
                + " с. "
                + (((bibliographicPointer.getAdditionally() != null)
                && (!bibliographicPointer.getAdditionally().equals("")))
                ? "(" + bibliographicPointer.getAdditionally() + ")"
                : "");
    }

    public String getBookReport(Book book) {
        return book.getAuthors()
                + " "
                + book.getName()
                + ": "
                + book.getStatement()
                + ". "
                + book.getPlace()
                + " : Вид-во "
                + book.getPublish()
                + ", "
                + book.getYear()
                + ". "
                + book.getCountOfSheets()
                + " c.";

    }

    public String getCatalogReport(Catalog catalog) {
        return catalog.getName()
                + " "
                + catalog.getName()
                + " / "
                + catalog.getOrganisation()
                + ". "
                + catalog.getCity()
                + ". "
                + catalog.getPlace()
                + " : "
                + catalog.getPublish()
                + ", "
                + catalog.getYear()
                + ". "
                +catalog.getSheet();
    }

    public String getDissertationReport(Dissertation dissertation) {
        return dissertation.getAuthors()
                + ". "
                + dissertation.getName()
                + " ["
                + dissertation.getType()
                + "]. "
                + dissertation.getPlace()
                + "; "
                + dissertation.getYear()
                + ". "
                + dissertation.getCountOfSheets() + " c.";
    }

    public String getElectronicResourceReport(ElectronicResource electronicResource) {
        return electronicResource.getAuthors()
                + "[Інтернет]"
                + electronicResource.getName()
                + "; [оновлено "
                + electronicResource.getUpdateDate()
                + "; цитовано "
                + electronicResource.getDate()
                + "]. Доступно: "
                + electronicResource.getUrl();
    }

    public String getLegislativeNormativeDocumentsReport(LegisNormDocuments legisNormDocuments) {
        return legisNormDocuments.getName()
                + ": "
                + legisNormDocuments.getType()
                + " від "
                + legisNormDocuments.getDateAccess() + " р. №"
                + legisNormDocuments.getNumber()
                + ". "
                + legisNormDocuments.getPublish()
                + ". "
                + legisNormDocuments.getDatePublish()
                + ". ("
                + legisNormDocuments.getSerial()
                + "). С. "
                + legisNormDocuments.getSheets() + ". ";
    }

    public String getPatentReport(Patent patent) {
        return patent.getAuthors()
                + ((patent.getAuthors().split(",").length > 1) ? " винахідники; " : " винахідник; ")
                + patent.getNamePatentOwner()
                + ", патентовласник. "
                + patent.getName()
                + ". Патент "
                + patent.getCountry()
                + "№ "
                + patent.getNumber()
                + ". "
                + patent.getDate() + ".";
    }

    public String getPreprintReport(Preprint preprint) {
        return preprint.getAuthors()
                + " "
                + preprint.getName()
                + ". "
                + preprint.getCity()
                + " : "
                + preprint.getPlace()
                + ", "
                + preprint.getYear()
                + ". "
                + preprint.getSheet()
                + " c.: Препринт. "
                + preprint.getOrganisation()
                + "; "
                + preprint.getAbbreviation() + ").";
    }

    public String getStandartReport(Standart standart) {
        return standart.getNameOfOrg()
                + " "
                + standart.getYearPublish()
                + ", "
                + standart.getName()
                + ": "
                + standart.getCodeLetter()
                + " "
                + standart.getCodeNumber()
                + ", "
                + standart.getPublish()
                + ", "
                + standart.getPlacePublish()
                + ".";
    }

    public String getThesisReport(Thesis thesis) {
        return thesis.getAuthors()
                + " "
                + thesis.getName()
                + ": "
                + thesis.getNamePublish()
                + ", "
                + thesis.getPlaceConference()
                + ", "
                + thesis.getDate()
                + ". "
                + thesis.getPlacePublish()
                + ", "
                + thesis.getYear()
                + ". С. "
                + thesis.getSheets() + ".";
    }


    public List<Data> getAllData() {
        return mAllData;
    }

    public void setAllData(List<Data> allData) {
        mAllData = allData;
    }

    public void setWork(Object work) {
        this.work = work;
    }

    public String getReport() {
        generate();
        return report;
    }


}
