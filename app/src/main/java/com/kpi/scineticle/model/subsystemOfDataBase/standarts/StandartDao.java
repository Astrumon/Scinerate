package com.kpi.scineticle.model.subsystemOfDataBase.standarts;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;

import java.util.List;

@Dao
public interface StandartDao {
    @Insert
    void insert(Standart standart);

    @Update
    void update(Standart standart);

    @Delete
    void delete(Standart standart);

    @Query("DELETE FROM standart_table")
    void deleteAll();

    @Query("SELECT * FROM standart_table ORDER BY name")
    LiveData<List<Standart>> getAllStandarts();
    @Query("SELECT * FROM standart_table WHERE userLogin = :userLogin ORDER BY name")
    LiveData<List<Standart>> getAllStandartsByLogin(String userLogin);

    @Query("Select * FROM standart_table WHERE nameOfOrg = :nameOfOrg")
    Standart getStandartByNameOfOrg(String nameOfOrg);

    @Query("Select * FROM standart_table WHERE name = :name")
    Standart getStandartByName(String name);

    @Query("DELETE FROM standart_table WHERE userLogin = :userLogin")
    void deleteAllByUserLogin(String userLogin);

    @Query("Select * FROM standart_table WHERE yearPublish = :yearPublish")
    Standart getStandartByYearOfPublish(String yearPublish);

    @Query("Select * FROM standart_table WHERE codeLetter = :codeLetter")
    Standart getStandartByCodeLetter(String codeLetter);

    @Query("Select * FROM standart_table WHERE codeNumber = :codeNumber")
    Standart getStandartByCodeNumber(String codeNumber);

    @Query("Select * FROM standart_table WHERE publish = :publish")
    Standart getStandartByPublish(String publish);

    @Query("Select * FROM standart_table WHERE placePublish = :placePublish")
    Standart getStandartByPlacePublish(String placePublish);

}
