package com.kpi.scineticle.model.subsystemOfDataBase.patents;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;

import java.util.List;

@Dao
public interface PatentDao {
    @Insert
    void insert(Patent patent);

    @Update
    void update(Patent patent);

    @Delete
    void delete(Patent patent);

    @Query("DELETE FROM patent_table")
    void deleteAll();

    @Query("SELECT * FROM patent_table ORDER BY name")
    LiveData<List<Patent>> getAllPatents();

    @Query("SELECT * FROM patent_table WHERE userLogin = :userLogin ORDER BY name")
    LiveData<List<Patent>> getAllPatentsByLogin(String userLogin);

    @Query("DELETE FROM patent_table WHERE userLogin = :userLogin")
    void deleteAllByUserLogin(String userLogin);

    @Query("Select * FROM patent_table WHERE name = :name")
    Patent getPatentByName(String name);

    @Query("Select * FROM patent_table WHERE namePatentOwner = :namePatentOwner")
    Patent getPatentByNamePatentOwner(String namePatentOwner);

    @Query("Select * FROM patent_table WHERE country = :country")
    Patent getPatentByCountry(String country);

    @Query("Select * FROM patent_table WHERE number = :number")
    Patent getPatentByNumber(String number);

    @Query("Select * FROM patent_table WHERE date = :date")
    Patent getPatentByDate(String date);

}
