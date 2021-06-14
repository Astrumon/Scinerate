package com.kpi.scineticle.model.subsystemOfDataBase.thesis;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;

import java.io.Serializable;

@Entity(tableName = "thesis_table")
public class Thesis extends ScientWork implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String authors;

    private String name;

    private String namePublish;

    private String date;

    private String placeConference;

    private String placePublish;

    private String year;

    private String sheets;

    private String loginUser;

    private int newest;

    public int getNewest() {
        return newest;
    }

    public void setNewest(int newest) {
        this.newest = newest;
    }

    public Thesis() {
        super.setTypeOfWork("Тезис");
    }

    public Thesis(String authors, String name, String namePublish,
                  String date, String placeConference,
                  String placePublish, String year, String sheets) {
        this.authors = authors;
        this.name = name;
        this.namePublish = namePublish;
        this.date = date;
        this.placeConference = placeConference;
        this.placePublish = placePublish;
        this.year = year;
        this.sheets = sheets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePublish() {
        return namePublish;
    }

    public void setNamePublish(String namePublish) {
        this.namePublish = namePublish;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlaceConference() {
        return placeConference;
    }

    public void setPlaceConference(String placeConference) {
        this.placeConference = placeConference;
    }

    public String getPlacePublish() {
        return placePublish;
    }

    public void setPlacePublish(String placePublish) {
        this.placePublish = placePublish;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSheets() {
        return sheets;
    }

    public void setSheets(String sheets) {
        this.sheets = sheets;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    @Override
    public String toString() {
        return "Thesis{" +
                "authors='" + authors + '\'' +
                ", name='" + name + '\'' +
                ", namePublish='" + namePublish + '\'' +
                ", date='" + date + '\'' +
                ", placeConference='" + placeConference + '\'' +
                ", placePublish='" + placePublish + '\'' +
                ", year='" + year + '\'' +
                ", sheets='" + sheets + '\'' +
                ", idUser=" + loginUser +
                '}';
    }

    public boolean isValidAuthors() {
        return mTextValidator.validateAuthorsName(authors);
    }

    public boolean isValidName() {
        return mTextValidator.validateName(name);
    }


    public boolean isValidDate() {
        return mTextValidator.validateDate(date);
    }

    public boolean isValidPlaceConferenece() {
        return mTextValidator.validateName(placeConference);
    }

    public boolean isValidNameConference() {
        return mTextValidator.validateName(namePublish);
    }

    public boolean isValidPlacePublish() {
        return mTextValidator.validateName(placePublish);
    }

    public boolean isValidYear() {
        return mTextValidator.validateYear(year);
    }

    public boolean isValidSheet() {
        return mTextValidator.validateSheet(sheets);
    }
}

