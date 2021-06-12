package com.kpi.scineticle.model.subsystemOfDataBase.bibliographic_pointers;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;

import java.io.Serializable;

@Entity(tableName = "bibliographic_pointers_table")
public class BibliographicPointer extends ScientWork implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String userLogin;

    private String name;

    private String numberOfRelease;

    private String authorOfRelease;

    private String aouthorsOfPublish;

    private String place;

    private String city;

    private String abbreviation;

    private String year;

    private String sheet;

    private String additionally;

    public BibliographicPointer() {
        super.setTypeOfWork("Бібліографічний покажчик");
    }

    public BibliographicPointer(String name, String numberOfRelease, String authorOfRelease, String aouthorsOfPublish, String place, String city, String abbreviation, String year, String sheet, String additionally) {
        this.name = name;
        this.numberOfRelease = numberOfRelease;
        this.authorOfRelease = authorOfRelease;
        this.aouthorsOfPublish = aouthorsOfPublish;
        this.place = place;
        this.city = city;
        this.abbreviation = abbreviation;
        this.year = year;
        this.sheet = sheet;
        this.additionally = additionally;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfRelease() {
        return numberOfRelease;
    }

    public void setNumberOfRelease(String numberOfRelease) {
        this.numberOfRelease = numberOfRelease;
    }

    public String getAuthorOfRelease() {
        return authorOfRelease;
    }

    public void setAuthorOfRelease(String authorOfRelease) {
        this.authorOfRelease = authorOfRelease;
    }

    public String getAouthorsOfPublish() {
        return aouthorsOfPublish;
    }

    public void setAouthorsOfPublish(String aouthorsOfPublish) {
        this.aouthorsOfPublish = aouthorsOfPublish;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
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

    public String getAdditionally() {
        return additionally;
    }

    public void setAdditionally(String additionally) {
        this.additionally = additionally;
    }

    @Override
    public String toString() {
        return "BibliographicPointers{" +
                "userLogin=" + userLogin +
                ", name='" + name + '\'' +
                ", release='" + numberOfRelease + '\'' +
                ", authorOfRelease='" + authorOfRelease + '\'' +
                ", aouthorsOfPublish='" + aouthorsOfPublish + '\'' +
                ", place='" + place + '\'' +
                ", city='" + city + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", year='" + year + '\'' +
                ", sheet='" + sheet + '\'' +
                ", additionally='" + additionally + '\'' +
                '}';
    }

    public boolean isValidAuthorsRelease() {
        return mTextValidator.validateAuthorsName(authorOfRelease);
    }

    public boolean isValidAuthorsPublish() {
        return mTextValidator.validateAuthorsName(aouthorsOfPublish);
    }

    public boolean isValidName() {
        return mTextValidator.validateName(name);
    }

    public boolean isValidCity() {
        return mTextValidator.validateCity(city);
    }

    public boolean isValidNumberOfRelease(){
        return mTextValidator.validateNumber(numberOfRelease);
    }

    public boolean isValidPlace() {
        return mTextValidator.validateStatement(place);
    }

    public boolean isValidYear() {
        return  mTextValidator.validateYear(year);
    }

    public boolean isValidSheet() {
        return mTextValidator.validateSheet(sheet);
    }

    public boolean isValidAbbreviation() {
        return mTextValidator.validateAbbreviation(abbreviation);
    }




}
