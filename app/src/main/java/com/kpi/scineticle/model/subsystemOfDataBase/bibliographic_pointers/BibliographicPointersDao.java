package com.kpi.scineticle.model.subsystemOfDataBase.bibliographic_pointers;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BibliographicPointersDao {

    @Insert
    void insert(BibliographicPointer bibliographicPointer);

    @Update
    void update(BibliographicPointer bibliographicPointer);

    @Delete
    void delete(BibliographicPointer bibliographicPointer);

    @Query("DELETE FROM bibliographic_pointers_table")
    void deleteAll();

    @Query("SELECT * FROM bibliographic_pointers_table ORDER BY name")
    LiveData<List<BibliographicPointer>> getAllBibliograbicPointers();

    @Query("Select * FROM bibliographic_pointers_table WHERE name = :name")
    BibliographicPointer getBibliographicPointersByName(String name);

    @Query("Select * FROM bibliographic_pointers_table WHERE numberOfRelease = :numberOfRelease")
    BibliographicPointer getBibliographicPointersByNumberOfRelease(String numberOfRelease);

    //TODO authorsOfRelease

    //TODO authorsOfPublish

    @Query("Select * FROM bibliographic_pointers_table WHERE place = :place")
    BibliographicPointer getBibliographicPointersByPlace(String place);

    @Query("Select * FROM bibliographic_pointers_table WHERE city = :city")
    BibliographicPointer getBibliographicPointersByCity(String city);

    @Query("Select * FROM bibliographic_pointers_table WHERE abbreviation = :abbreviation")
    BibliographicPointer getBibliographicPointersByAbbreviation(String abbreviation);

    @Query("Select * FROM bibliographic_pointers_table WHERE year = :year")
    BibliographicPointer getBibliographicPointersByYear(String year);

    @Query("Select * FROM bibliographic_pointers_table WHERE sheet = :sheet")
    BibliographicPointer getBibliographicPointersBySheet(String sheet);

    @Query("Select * FROM bibliographic_pointers_table WHERE additionally = :additionally")
    BibliographicPointer getBibliographicPointersByAdditionally(String additionally);


}
