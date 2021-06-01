package com.kpi.scineticle.model.subsystemOfDataBase.dissertations;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;

import java.util.List;

@Dao
public interface DissertationDao {
    @Insert
    void insert(Dissertation dissertation);

    @Update
    void update(Dissertation dissertation);

    @Delete
    void delete(Dissertation dissertation);

    @Query("DELETE FROM dissertation_table")
    void deleteAll();

    @Query("SELECT * FROM dissertation_table ORDER BY name")
    LiveData<List<Dissertation>> getAllDissertations();

    @Query("DELETE FROM dissertation_table WHERE userLogin = :userLogin")
    void deleteAllByUserLogin(String userLogin);

    @Query("SELECT * FROM dissertation_table WHERE userLogin = :userLogin ORDER BY name")
    LiveData<List<Dissertation>> getAllDissertationByLogin(String userLogin);

    @Query("Select * FROM dissertation_table WHERE name = :name")
    Dissertation getDissertationByName(String name);

    @Query("Select * FROM dissertation_table WHERE type = :type")
    Dissertation getDissertationByType(String type);

    @Query("Select * FROM dissertation_table WHERE place = :place")
    Dissertation getDissertationByPlace(String place);

    @Query("Select * FROM dissertation_table WHERE publish = :publish")
    Dissertation getDissertationByPublish(String publish);

    @Query("Select * FROM dissertation_table WHERE year = :year")
    Dissertation getDissertationByYear(String year);

    @Query("Select * FROM dissertation_table WHERE countOfSheets = :countOfSheets")
    Dissertation getDissertationByCountOfSheets(int countOfSheets);



}
