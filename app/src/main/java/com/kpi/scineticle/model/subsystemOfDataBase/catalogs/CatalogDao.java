package com.kpi.scineticle.model.subsystemOfDataBase.catalogs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;
import com.kpi.scineticle.model.subsystemOfDataBase.preprints.Preprint;

import java.util.List;

@Dao
public interface CatalogDao {

    @Insert
    void insert(Catalog catalog);

    @Update
    void update(Catalog catalog);

    @Delete
    void delete(Catalog catalog);

    @Query("DELETE FROM catalog_table")
    void deleteAll();

    @Query("DELETE FROM catalog_table WHERE userLogin = :userLogin")
    void deleteAllByUserLogin(String userLogin);

    @Query("SELECT * FROM catalog_table ORDER BY name")
    LiveData<List<Catalog>> getAllCatalogs();

    @Query("SELECT * FROM catalog_table WHERE userLogin = :userLogin ORDER BY name")
    LiveData<List<Catalog>> getAllCatalogsByLogin(String userLogin);

    @Query("Select * FROM catalog_table WHERE name = :name")
    Catalog getCatalogByName(String name);

    @Query("Select * FROM catalog_table WHERE place = :place")
    Catalog getCatalogByPlace(String place);

    @Query("Select * FROM catalog_table WHERE city = :city")
    Catalog getCatalogByCity(String city);

    @Query("Select * FROM catalog_table WHERE publish = :publish")
    Catalog getCatalogByPublish(String publish);

    @Query("Select * FROM catalog_table WHERE year = :year")
    Catalog getCatalogByYear(String year);

    @Query("Select * FROM catalog_table WHERE sheet = :sheet")
    Catalog getCatalogBySheet(String sheet);
}
