package com.kpi.scineticle.model;

import android.util.Log;

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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable{
    public static final int ARTICLE = 1;
    public static final int BOOK = 2;
    public static final int BIBLIOGRAPHIC_POINTER = 3;
    public static final int CATALOG = 4;
    public static final int DISSERTATION = 5;
    public static final int ELECTRONIC_RESOURCE = 6;
    public static final int LEGIS_NORM_DOCUMENTS = 7;
    public static final int PATENT = 8;
    public static final int PREPRINT = 9;
    public static final int STANDART = 10;
    public static final int THESIS = 11;

    public int id;
    public String authors;
    public String date;
    public String typeWork;
    public String name;
    public String year;

    public int type;
    public Article article;
    public Book book;
    public BibliographicPointer bibliographicPointer;
    public Catalog catalog;
    public Dissertation dissertation;
    public ElectronicResource electronicResource;
    public LegisNormDocuments legisNormDocuments;
    public Patent patent;
    public Preprint preprint;
    public Standart standart;
    public Thesis thesis;

    public static List<Data> merge(List<Article> articles,
                                   List<Book> books,
                                   List<BibliographicPointer> bibliographicPointers,
                                   List<Dissertation> dissertations,
                                   List<Catalog> catalogs,
                                   List<ElectronicResource> electronicResources,
                                   List<LegisNormDocuments> legisNormDocumentss,
                                   List<Patent> patents,
                                   List<Preprint> preprints,
                                   List<Standart> standarts,
                                   List<Thesis> theses) {

        List<Data> datas = new ArrayList<>();
        for (Article article : articles) {
            Data data = new Data();
            data.id = article.getNewest();
            data.typeWork = ScientWork.ARTICLE;
            data.name = article.getNameArticle();
            data.authors = article.getAuthors();
            data.date = article.getDate();
            data.article = article;
            data.book = null;
            data.bibliographicPointer = null;
            data.catalog = null;
            data.dissertation = null;
            data.electronicResource = null;
            data.legisNormDocuments = null;
            data.patent = null;
            data.preprint = null;
            data.standart = null;
            data.thesis = null;
            data.type = Data.ARTICLE;
            datas.add(data);
        }

        for (Book book : books) {
            Data data = new Data();
            data.id = book.getNewest();
            data.typeWork = ScientWork.BOOK;
            data.name = book.getName();
            data.authors = book.getAuthors();
            data.year = book.getYear();
            data.article = null;
            data.bibliographicPointer = null;
            data.book = book;
            data.catalog = null;
            data.dissertation = null;
            data.electronicResource = null;
            data.legisNormDocuments = null;
            data.patent = null;
            data.preprint = null;
            data.standart = null;
            data.thesis = null;
            data.type = Data.BOOK;
            datas.add(data);
        }

        for (BibliographicPointer bibliographicPointer: bibliographicPointers) {
            Data data = new Data();
            data.id = bibliographicPointer.getNewest();
            data.typeWork = ScientWork.BIBLIOGRAPHIC_POINTER;
            data.name = bibliographicPointer.getName();
            data.authors = bibliographicPointer.getAuthorOfRelease();
            data.year = bibliographicPointer.getYear();
            data.article = null;
            data.book = null;
            data.bibliographicPointer = bibliographicPointer;
            data.catalog = null;
            data.dissertation = null;
            data.electronicResource = null;
            data.legisNormDocuments = null;
            data.patent = null;
            data.preprint = null;
            data.standart = null;
            data.thesis = null;
            data.type = Data.BIBLIOGRAPHIC_POINTER;
            datas.add(data);
        }

        for (Catalog catalog: catalogs) {
            Data data = new Data();
            data.id = catalog.getNewest();
            data.year = catalog.getYear();
            data.typeWork = ScientWork.CATALOG;
            data.name = catalog.getName();
            data.authors = catalog.getAuthors();
            data.article = null;
            data.book = null;
            data.bibliographicPointer = null;
            data.catalog = catalog;
            data.dissertation = null;
            data.electronicResource = null;
            data.legisNormDocuments = null;
            data.patent = null;
            data.preprint = null;
            data.standart = null;
            data.thesis = null;
            data.type = Data.CATALOG;
            datas.add(data);
        }

        for (Dissertation dissertation: dissertations) {
            Data data = new Data();
            data.id = dissertation.getNewest();
            data.year = dissertation.getYear();
            data.typeWork = ScientWork.DISSERTATION;
            data.name = dissertation.getName();
            data.authors = dissertation.getAuthors();
            data.article = null;
            data.book = null;
            data.bibliographicPointer = null;
            data.catalog = null;
            data.dissertation = dissertation;
            data.electronicResource = null;
            data.legisNormDocuments = null;
            data.patent = null;
            data.preprint = null;
            data.standart = null;
            data.thesis = null;
            data.type = Data.DISSERTATION;
            datas.add(data);
        }

        for (ElectronicResource electronicResource: electronicResources) {
            Data data = new Data();
            data.id = electronicResource.getNewest();
            data.typeWork = ScientWork.ELECTRONIC_RESOURCE;
            data.name = electronicResource.getName();
            data.authors = electronicResource.getAuthors();
            data.date = electronicResource.getDate();
            data.article = null;
            data.book = null;
            data.bibliographicPointer = null;
            data.catalog = null;
            data.dissertation = null;
            data.electronicResource = electronicResource;
            data.legisNormDocuments = null;
            data.patent = null;
            data.preprint = null;
            data.standart = null;
            data.thesis = null;
            data.type = Data.ELECTRONIC_RESOURCE;
            datas.add(data);
        }

        for (LegisNormDocuments legisNormDocument: legisNormDocumentss) {
            Data data = new Data();
            data.id = legisNormDocument.getNewest();
            data.typeWork = ScientWork.LEGIS_NORM_DOCUMENTS;
            data.name = legisNormDocument.getName();
            data.date = legisNormDocument.getDatePublish();
            data.article = null;
            data.book = null;
            data.bibliographicPointer = null;
            data.catalog = null;
            data.dissertation = null;
            data.electronicResource = null;
            data.legisNormDocuments = legisNormDocument;
            data.patent = null;
            data.preprint = null;
            data.standart = null;
            data.thesis = null;
            data.type = Data.LEGIS_NORM_DOCUMENTS;
            datas.add(data);
        }

        for (Patent patent: patents) {
            Data data = new Data();
            data.id = patent.getNewest();
            data.typeWork = ScientWork.PATENT;
            data.name = patent.getName();
            data.date = patent.getDate();
            data.authors = patent.getAuthors();
            data.article = null;
            data.book = null;
            data.bibliographicPointer = null;
            data.catalog = null;
            data.dissertation = null;
            data.electronicResource = null;
            data.legisNormDocuments = null;
            data.patent = patent;
            data.preprint = null;
            data.standart = null;
            data.thesis = null;
            data.type = Data.PATENT;
            datas.add(data);
        }

        for (Preprint preprint: preprints) {
            Data data = new Data();
            data.id = preprint.getNewest();
            data.typeWork = ScientWork.PREPRINT;
            data.name = preprint.getName();
            data.year = preprint.getYear();
            data.authors = preprint.getAuthors();
            data.article = null;
            data.book = null;
            data.bibliographicPointer = null;
            data.catalog = null;
            data.dissertation = null;
            data.electronicResource = null;
            data.legisNormDocuments = null;
            data.patent = null;
            data.preprint = preprint;
            data.standart = null;
            data.thesis = null;
            data.type = Data.PREPRINT;
            datas.add(data);
        }

        for (Standart standart: standarts) {
            Data data = new Data();
            data.id = standart.getNewest();
            data.typeWork = ScientWork.STANDART;
            data.name = standart.getName();
            data.year = standart.getYearPublish();
            data.article = null;
            data.book = null;
            data.bibliographicPointer = null;
            data.catalog = null;
            data.dissertation = null;
            data.electronicResource = null;
            data.legisNormDocuments = null;
            data.patent = null;
            data.preprint = null;
            data.standart = standart;
            data.thesis = null;
            data.type = Data.STANDART;
            datas.add(data);
        }

        for (Thesis thesis: theses) {
            Data data = new Data();
            data.id = thesis.getNewest();
            data.typeWork = ScientWork.THESIS;
            data.name = thesis.getName();
            data.year = thesis.getYear();
            data.authors = thesis.getAuthors();
            data.date = thesis.getDate();
            data.article = null;
            data.book = null;
            data.bibliographicPointer = null;
            data.catalog = null;
            data.dissertation = null;
            data.electronicResource = null;
            data.legisNormDocuments = null;
            data.patent = null;
            data.preprint = null;
            data.standart = null;
            data.thesis = thesis;
            data.type = Data.THESIS;
            datas.add(data);
        }

        return datas;
    }

    public static int defineTypeOfData(Object o) {
        if (o instanceof Article) {
            return ARTICLE;
        }

        if (o instanceof Book) {
            return BOOK;
        }

        if (o instanceof BibliographicPointer) {
            return BIBLIOGRAPHIC_POINTER;
        }

        if (o instanceof Catalog) {
            return CATALOG;
        }

        if (o instanceof Dissertation) {
            return DISSERTATION;
        }

        if (o instanceof ElectronicResource) {
            return ELECTRONIC_RESOURCE;
        }

        if (o instanceof LegisNormDocuments) {
            return LEGIS_NORM_DOCUMENTS;
        }

        if (o instanceof Patent) {
            return PATENT;
        }

        if (o instanceof Preprint) {
            return PREPRINT;
        }

        if (o instanceof Standart) {
            return STANDART;
        }

        if (o instanceof Thesis) {
            return THESIS;
        }

        return 0;
    }

}
