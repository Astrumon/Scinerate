package com.kpi.scineticle.model.subsystemOfDataBase.legislative_normative_documents;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;

@Entity (tableName = "legislative_normative_documents")
public class LegisNormDocuments extends ScientWork {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private String type;

    private String dateAccess;

    private String number;

    private String publish;

    private String datePublish;

    private String serial;

    private String sheets;

    private String userLogin;

    public LegisNormDocuments() {
    }

    public LegisNormDocuments(String name, String type, String dateAccess, String number, String publish, String datePublish, String serial, String sheets) {
        this.name = name;
        this.type = type;
        this.dateAccess = dateAccess;
        this.number = number;
        this.publish = publish;
        this.datePublish = datePublish;
        this.serial = serial;
        this.sheets = sheets;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDateAccess() {
        return dateAccess;
    }

    public void setDateAccess(String dateAccess) {
        this.dateAccess = dateAccess;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(String datePublish) {
        this.datePublish = datePublish;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
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

    @Override
    public String toString() {
        return "LegisNormDoucuments{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", dateAccess='" + dateAccess + '\'' +
                ", number='" + number + '\'' +
                ", publish='" + publish + '\'' +
                ", datePublish='" + datePublish + '\'' +
                ", serial='" + serial + '\'' +
                ", sheets='" + sheets + '\'' +
                ", userLogin=" + userLogin +
                '}';
    }
}
