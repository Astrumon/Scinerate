package com.kpi.scineticle.model.subsystemOfDataBase.book;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDao {
    @Insert
    void insert(Book book);

    @Update
    void update(Book book);

    @Delete
    void delete(Book book);

    @Query("DELETE FROM book_table")
    void deleteAll();

    @Query("DELETE FROM book_table WHERE userLogin = :userLogin")
    void deleteAllByUserLogin(String userLogin);

    @Query("SELECT * FROM book_table ORDER BY name")
    LiveData<List<Book>> getAllBooks();

    @Query("SELECT * FROM book_table WHERE userLogin = :userLogin ORDER BY name")
    LiveData<List<Book>> getAllBooksByLogin(String userLogin);

    @Query("Select * FROM book_table WHERE name = :name")
    Book getBookByName(String name);

    @Query("Select * FROM book_table WHERE statement = :statement")
    Book getBookByStatement(String statement);

    @Query("Select * FROM book_table WHERE place = :place")
    Book getBookByPlace(String place);

    @Query("Select * FROM book_table WHERE year = :year")
    Book getBookByYear(String year);

    @Query("Select * FROM book_table WHERE countOfSheets = :countOfSheets")
    Book getBookByCountOfSheets(int countOfSheets);

    @Query("Select * FROM book_table WHERE publish = :publish")
    Book getBookByPublish(String publish);

}
