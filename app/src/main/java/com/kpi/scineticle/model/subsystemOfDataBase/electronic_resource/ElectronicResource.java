package com.kpi.scineticle.model.subsystemOfDataBase.electronic_resource;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;

import java.io.Serializable;

@Entity (tableName = "el_resource_table")
public class ElectronicResource extends ScientWork implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String authors;

    private String name;

    private String placePublish;

    private String publish;

    private String date;

    private String updateDate;

    private String url;

    private String userLogin;

    public ElectronicResource() {
        super.setTypeOfWork("Електроний ресурс");
    }

    public ElectronicResource(String authors, String name, String placePublish, String publish, String date, String updateDate, String url) {
        this.authors = authors;
        this.name = name;
        this.placePublish = placePublish;
        this.publish = publish;
        this.date = date;
        this.updateDate = updateDate;
        this.url = url;

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

    public String getPlacePublish() {
        return placePublish;
    }

    public void setPlacePublish(String placePublish) {
        this.placePublish = placePublish;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "ElectronicResource{" +
                "authors='" + authors + '\'' +
                ", name='" + name + '\'' +
                ", placePublish='" + placePublish + '\'' +
                ", publish='" + publish + '\'' +
                ", date='" + date + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", url='" + url + '\'' +
                ", userLogin=" + userLogin +
                '}';
    }
    public boolean isValidAuthors() {
        return mTextValidator.validateAuthorsName(authors);
    }

    public boolean isValidName() {
        return mTextValidator.validateName(name);
    }

    public boolean isValidPlacePublish() {
        return mTextValidator.validateStatement(placePublish);
    }

    public boolean isValidPublish() {
        return mTextValidator.validateName(publish);
    }

    public boolean isValidDate() {
        return mTextValidator.validateDate(date);
    }

    public boolean isValidUpdateDate() {
        return mTextValidator.validateYear(updateDate);
    }

    public boolean isValidURL() {
        return mTextValidator.validURL(url);
    }


}
