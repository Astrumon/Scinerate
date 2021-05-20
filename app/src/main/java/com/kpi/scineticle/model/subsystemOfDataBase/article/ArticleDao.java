package com.kpi.scineticle.model.subsystemOfDataBase.article;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;

import java.util.List;

@Dao
public interface ArticleDao {
    @Insert
    void insert(Article article);

    @Update
    void update(Article article);

    @Delete
    void delete(Article article);

    @Query("DELETE FROM article_table")
    void deleteAll();

    @Query("SELECT * FROM article_table ORDER BY nameArticle")
    LiveData<List<Article>> getAllArticles();

    @Query("Select * FROM article_table WHERE nameArticle = :nameArticle")
    Article getArticleName(String nameArticle);

    @Query("Select * FROM article_table WHERE nameJournal = :nameJournal")
    Article getArticleNameJournal(String nameJournal);

    @Query("Select * FROM article_table WHERE date = :date")
    Article getArticleDatePublishing(String date);

    @Query("Select * FROM article_table WHERE number = :number")
    Article getArticleNumber(String number);

    @Query("Select * FROM article_table WHERE sheets = :sheets")
    Article getArticleSheets(String sheets);

}
