package com.kpi.scineticle.model.subsystemOfDataBase.article;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "article_table")
public class Article {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String authors;

    private String nameArticle;

    private String nameJournal;

    private String date;

    private String number;

    private String sheets;

    private String userLogin;

    public Article() {

    }

    public Article(String authors, String nameArticle, String nameJournal, String date, String number, String sheets) {
        this.authors = authors;
        this.nameArticle = nameArticle;
        this.nameJournal = nameJournal;
        this.date = date;
        this.number = number;
        this.sheets = sheets;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getNameArticle() {
        return nameArticle;
    }

    public void setNameArticle(String nameArticle) {
        this.nameArticle = nameArticle;
    }

    public String getNameJournal() {
        return nameJournal;
    }

    public void setNameJournal(String nameJournal) {
        this.nameJournal = nameJournal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSheets() {
        return sheets;
    }

    public void setSheets(String sheets) {
        this.sheets = sheets;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Article{" +
                ", authors='" + authors + '\'' +
                ", nameArticle='" + nameArticle + '\'' +
                ", nameJournal='" + nameJournal + '\'' +
                ", date='" + date + '\'' +
                ", number='" + number + '\'' +
                ", sheets='" + sheets + '\'' +
                ", userLogin=" + userLogin +
                '}';
    }
}
