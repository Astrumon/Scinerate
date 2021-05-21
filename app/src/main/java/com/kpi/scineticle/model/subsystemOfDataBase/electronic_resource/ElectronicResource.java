package com.kpi.scineticle.model.subsystemOfDataBase.electronic_resource;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "el_resource_table")
public class ElectronicResource {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String authors;

    private String name;

    private String placePublish;

    private String publish;

    private String date;

    private String updateDate;

    private String url;

    private int idUser;

    public ElectronicResource() {

    }

    public ElectronicResource(String authors, String name, String placePublish, String publish, String date, String updateDate, String url, int idUser) {
        this.authors = authors;
        this.name = name;
        this.placePublish = placePublish;
        this.publish = publish;
        this.date = date;
        this.updateDate = updateDate;
        this.url = url;
        this.idUser = idUser;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
                ", idUser=" + idUser +
                '}';
    }
}
