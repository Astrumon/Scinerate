package com.kpi.scineticle.model.subsystemOfDataBase.electronic_resource;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;

import java.util.List;

@Dao
public interface ElectronicResourceDao {
    @Insert
    void insert(ElectronicResource electronicResource);

    @Update
    void update(ElectronicResource electronicResource);

    @Delete
    void delete(ElectronicResource electronicResource);

    @Query("DELETE FROM el_resource_table")
    void deleteAll();

    @Query("DELETE FROM el_resource_table WHERE userLogin = :userLogin")
    void deleteAllByUserLogin(String userLogin);

    @Query("SELECT * FROM el_resource_table ORDER BY name")
    LiveData<List<ElectronicResource>> getAllElectronicResources();

    @Query("SELECT * FROM el_resource_table WHERE userLogin = :userLogin ORDER BY name")
    LiveData<List<ElectronicResource>> getAllElectronicResourcesByLogin(String userLogin);

    @Query("Select * FROM el_resource_table WHERE name = :name")
    ElectronicResource getElectronicByName(String name);

    @Query("Select * FROM el_resource_table WHERE placePublish = :placePublish")
    ElectronicResource getElectronicByPlacePublish(String placePublish);

    @Query("Select * FROM el_resource_table WHERE publish = :publish")
    ElectronicResource getElectronicByPublish(String publish);

    @Query("Select * FROM el_resource_table WHERE date = :date")
    ElectronicResource getElectronicByDate(String date);

    @Query("Select * FROM el_resource_table WHERE updateDate = :updateDate")
    ElectronicResource getElectronicByUpdateDate(String updateDate);

    @Query("Select * FROM el_resource_table WHERE url = :url")
    ElectronicResource getElectronicByUrl(String url);
}
