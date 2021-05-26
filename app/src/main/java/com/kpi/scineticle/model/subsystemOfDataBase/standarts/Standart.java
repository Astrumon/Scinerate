package com.kpi.scineticle.model.subsystemOfDataBase.standarts;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "standart_table")
public class Standart {

    @PrimaryKey
    private int id;

    private String userLogin;

    private String nameOfOrg;

    private String yearPublish;

    private String name;

    private String codeLetter;

    private String codeNumber;

    private String publish;

    private String placePublish;

    public Standart() {
    }

    public Standart(String nameOfOrg, String yearPublish, String name, String codeLetter, String codeNumber, String publish, String placePublish) {
        this.nameOfOrg = nameOfOrg;
        this.yearPublish = yearPublish;
        this.name = name;
        this.codeLetter = codeLetter;
        this.codeNumber = codeNumber;
        this.publish = publish;
        this.placePublish = placePublish;
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

    public String getNameOfOrg() {
        return nameOfOrg;
    }

    public void setNameOfOrg(String nameOfOrg) {
        this.nameOfOrg = nameOfOrg;
    }

    public String getYearPublish() {
        return yearPublish;
    }

    public void setYearPublish(String yearPublish) {
        this.yearPublish = yearPublish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeLetter() {
        return codeLetter;
    }

    public void setCodeLetter(String codeLetter) {
        this.codeLetter = codeLetter;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getPlacePublish() {
        return placePublish;
    }

    public void setPlacePublish(String placePublish) {
        this.placePublish = placePublish;
    }

    @Override
    public String toString() {
        return "Standart{" +
                "idUser=" + userLogin +
                ", nameOfOrg='" + nameOfOrg + '\'' +
                ", yearPublish='" + yearPublish + '\'' +
                ", name='" + name + '\'' +
                ", codeLetter='" + codeLetter + '\'' +
                ", codeNumber='" + codeNumber + '\'' +
                ", publish='" + publish + '\'' +
                ", placePublish='" + placePublish + '\'' +
                '}';
    }
}
