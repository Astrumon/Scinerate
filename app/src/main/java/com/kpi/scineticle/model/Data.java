package com.kpi.scineticle.model;

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

import java.util.ArrayList;
import java.util.List;

public class Data {
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

    int type;
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
}
