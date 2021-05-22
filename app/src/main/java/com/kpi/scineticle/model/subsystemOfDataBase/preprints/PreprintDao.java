package com.kpi.scineticle.model.subsystemOfDataBase.preprints;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

@Dao
public interface PreprintDao {
    @Insert
    void insert(Preprint preprint);

    @Update
    void update(Preprint preprint);

    @Delete
    void delete(Preprint preprint);

    @Query("DELETE FROM standart_table")
    void deleteAll();

    @Query("SELECT * FROM preprint_table ORDER BY name")
    LiveData<List<Preprint>> getAllPreprints();

    @Query("Select * FROM preprint_table WHERE name = :name")
    Preprint getPreprintsByName(String name);

    @Query("Select * FROM preprint_table WHERE city = :city")
    Preprint getPreprintsByCity(String city);

    @Query("Select * FROM preprint_table WHERE place = :place")
    Preprint getPreprintsByPlace(String place);

    @Query("Select * FROM preprint_table WHERE year = :year")
    Preprint getPreprintsByYear(String year);

    @Query("Select * FROM preprint_table WHERE sheet = :sheet")
    Preprint getPreprintsBySheet(String sheet);

    @Query("Select * FROM preprint_table WHERE organisation = :organisation")
    Preprint getPreprintsByOrganisation(String organisation);

    @Query("Select * FROM preprint_table WHERE abbreviation = :abbreviation")
    Preprint getPreprintsByAbbreviation(String abbreviation);
}
