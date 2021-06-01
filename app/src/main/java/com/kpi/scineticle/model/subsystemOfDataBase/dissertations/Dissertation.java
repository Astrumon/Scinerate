package com.kpi.scineticle.model.subsystemOfDataBase.dissertations;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;

@Entity(tableName = "dissertation_table")
public class Dissertation extends ScientWork {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String authors;

    private String name;

    private String type;

    private String place;

    private String publish;

    private String year;

    private String countOfSheets;

    private String userLogin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dissertation() {
        super.setTypeOfWork("Дисертація");
    }

    public Dissertation(String authors, String name, String type, String place, String publish, String year, String countOfSheets) {
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

    public String getCountOfSheets() {
        return countOfSheets;
    }

    public void setCountOfSheets(String countOfSheets) {
        this.countOfSheets = countOfSheets;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
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
                ", idUser=" + userLogin +
                '}';
    }
}
