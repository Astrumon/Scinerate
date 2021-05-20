package com.kpi.scineticle.model.subsystemOfDataBase.dissertations;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dissertation_table")
public class Dissertation {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String authors;

    private String name;

    private String type;

    private String place;

    private String publish;

    private String year;

    private int countOfSheets;

    private int idUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dissertation() {

    }

    public Dissertation(String authors, String name, String type, String place, String publish, String year, int countOfSheets) {
        this.authors = authors;
        this.name = name;
        this.type = type;
        this.place = place;
        this.publish = publish;
        this.year = year;
        this.countOfSheets = countOfSheets;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCountOfSheets() {
        return countOfSheets;
    }

    public void setCountOfSheets(int countOfSheets) {
        this.countOfSheets = countOfSheets;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Dissertation{" +
                "authors='" + authors + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", place='" + place + '\'' +
                ", publish='" + publish + '\'' +
                ", year='" + year + '\'' +
                ", countOfSheets=" + countOfSheets +
                ", idUser=" + idUser +
                '}';
    }
}
