package com.kpi.scineticle.model.subsystemOfDataBase.catalogs;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;

import java.io.Serializable;

@Entity (tableName = "catalog_table")
public class Catalog extends ScientWork implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String userLogin;

    private String authors;

    private String name;

    private String city;

    private String place;

    private String year;

    private String sheet;

    private String publish;

    private String organisation;

    private String abbreviation;

    private int newest;

    public int getNewest() {
        return newest;
    }

    public void setNewest(int newest) {
        this.newest = newest;
    }

    public Catalog() {
        super.setTypeOfWork("Каталог");
    }

    public Catalog(String authors, String name, String city, String publish, String place, String year, String sheet, String organisation, String abbreviation) {
        this.authors = authors;
        this.name = name;
        this.city = city;
        this.place = place;
        this.year = year;
        this.sheet = sheet;
        this.organisation = organisation;
        this.abbreviation = abbreviation;
        this.publish = publish;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
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
        return "Catalog{" +
                "idUser=" + userLogin +
                ", authors='" + authors + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", publish='" + publish +'\'' +
                ", place='" + place + '\'' +
                ", year='" + year + '\'' +
                ", sheet='" + sheet + '\'' +
                ", organisation='" + organisation + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }

    public boolean isValidAuthors() {
        return mTextValidator.validateAuthorsName(authors);
    }

    public boolean isValidName() {
        return mTextValidator.validateName(name);
    }

    public boolean isValidCity() {
        return mTextValidator.validateCity(city);
    }

    public boolean isValidPublish() {
        return mTextValidator.validateStatement(publish);
    }

    public boolean isValidPlace() {
        return mTextValidator.validateStatement(place);
    }

    public boolean isValidYear() {
        return mTextValidator.validateYear(year);
    }

    public boolean isValidSheet() {
        return mTextValidator.validateSheet(sheet);
    }

    public boolean isValidOrganisation() {
        return mTextValidator.validateName(organisation);
    }

    public boolean isValidAbbreviation() {
        return mTextValidator.validateAbbreviation(abbreviation);
    }
}
