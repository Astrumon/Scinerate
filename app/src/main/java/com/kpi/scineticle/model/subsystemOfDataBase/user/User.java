package com.kpi.scineticle.model.subsystemOfDataBase.user;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.util.StringUtil;

import com.kpi.scineticle.model.InvalidPasswordException;
import com.kpi.scineticle.model.PasswordValidator;

import java.util.regex.Pattern;


@Entity(tableName = "user_table", indices = {
        @Index(value = {"email"}, unique = true)
})
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private String lastName;

    private String password;

    private String email;

    public User() {
    }

    public User(String name, String email, String lastName, String password) {
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
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


    public boolean isValidName() {
        return this.name != null && !TextUtils.isEmpty(name) && Pattern.compile("[\\p{L}| a-zA-Z]+").matcher(name).matches();
    }

    public boolean isValidLastName() {
        return this.lastName != null && !TextUtils.isEmpty(lastName) && Pattern.compile("[\\p{L}| a-zA-Z]+").matcher(lastName).matches();
    }

    public boolean isValidEmail() {
        return this.email != null && !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    public boolean isValidPassword() throws InvalidPasswordException {
        PasswordValidator.isValid(password);
        return PasswordValidator.isIsValid();
    }



    public String toString() {
        return "User[name= " + name + ", mail= " + email + "]";
    }
}
