package com.kpi.scineticle.model.subsystemOfDataBase.preprints;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "preprint_table")
public class Preprint {

    @PrimaryKey
    private int id;

    private String userLogin;

    private String authors;

    private String name;

    private String city;

    private String place;

    private String year;

    private String sheet;

    private String organisation;

    private String abbreviation;

    public Preprint() {
    }

    public Preprint(String authors, String name, String city, String place, String year, String sheet, String organisation, String abbreviation) {
        this.authors = authors;
        this.name = name;
        this.city = city;
        this.place = place;
        this.year = year;
        this.sheet = sheet;
        this.organisation = organisation;
        this.abbreviation = abbreviation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSheet() {
        return sheet;
    }

    public void setSheet(String sheet) {
        this.sheet = sheet;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "Preprint{" +
                "idUser=" + userLogin +
                ", authors='" + authors + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", place='" + place + '\'' +
                ", year='" + year + '\'' +
                ", sheet='" + sheet + '\'' +
                ", organisation='" + organisation + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }
}
