package com.kpi.scineticle.model.subsystemOfDataBase.thesis;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ThesisDao {
    @Insert
    void insert(Thesis thesis);

    @Update
    void update(Thesis thesis);

    @Delete
    void delete(Thesis thesis);

    @Query("DELETE FROM thesis_table")
    void deleteAll();

    @Query("SELECT * FROM thesis_table ORDER BY name")
    LiveData<List<Thesis>> getAllThesis();

    @Query("Select * FROM thesis_table WHERE name = :name")
    Thesis getThesisByName(String name);

    @Query("Select * FROM thesis_table WHERE namePublish = :namePublish")
    Thesis getThesisByNamePublish(String namePublish);

    @Query("Select * FROM thesis_table WHERE date = :date")
    Thesis getThesisByDate(String date);

    @Query("Select * FROM thesis_table WHERE placeConference = :placeConference")
    Thesis getThesisByPlaceConference(String placeConference);

    @Query("Select * FROM thesis_table WHERE placePublish = :placePublish")
    Thesis getThesisByPlacePublish(String placePublish);

    @Query("Select * FROM thesis_table WHERE year = :year")
    Thesis getThesisByYear(String year);

    @Query("Select * FROM thesis_table WHERE sheets = :sheets")
    Thesis getThesisBySheets(String sheets);
}
