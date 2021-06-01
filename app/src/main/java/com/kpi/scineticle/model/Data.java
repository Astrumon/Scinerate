package com.kpi.scineticle.model;

import com.kpi.scineticle.model.subsystemOfDataBase.article.Article;
import com.kpi.scineticle.model.subsystemOfDataBase.bibliographic_pointers.BibliographicPointer;
import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static final int ARTICLE = 1;
    public static final int BOOK = 2;
    public static final int BIBLIOGRAPHIC_POINTER = 3;

    int type;
    public Article article;
    public Book book;
    public BibliographicPointer bibliographicPointer;

    public static List<Data> merge(List<Article> articles, List<Book> books, List<BibliographicPointer> bibliographicPointers) {
        List<Data> datas = new ArrayList<>();
        for (Article article : articles) {
            Data data = new Data();
            data.article = article;
            data.book = null;
            data.bibliographicPointer = null;
            data.type = Data.ARTICLE;
            datas.add(data);
        }

        for (Book book : books) {
            Data data = new Data();
            data.article = null;
            data.bibliographicPointer = null;
            data.book = book;
            data.type = Data.BOOK;
            datas.add(data);
        }

        for (BibliographicPointer bibliographicPointer: bibliographicPointers) {
            Data data = new Data();
            data.article = null;
            data.book = null;
            data.bibliographicPointer = bibliographicPointer;
            data.type = Data.BIBLIOGRAPHIC_POINTER;
            datas.add(data);
        }

        return datas;
    }
}
