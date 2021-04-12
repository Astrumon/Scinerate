package com.kpi.scineticle.model;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.util.StringUtil;

import java.util.regex.Pattern;

@Entity(tableName = "user_table")
public class User {
    //TODO isValid mail, phoneNumber

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private String email;

    private String phoneNumber;

    public User() {
    }

    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isValidName() {
        if (this.name != null && !TextUtils.isEmpty(name) && Pattern.compile("[\\p{L}| a-zA-Z]+").matcher(name).matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidEmail() {
        if (this.email != null && !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidPhone() {
        if (this.phoneNumber != null && !TextUtils.isEmpty(phoneNumber) && Pattern.compile("^\\+38\\d{10}$").matcher(phoneNumber).matches()) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "User[name= " + name + ", phone= " + phoneNumber + ", mail= " + email + "]";
    }




}
