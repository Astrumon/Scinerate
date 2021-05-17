package com.kpi.scineticle.model.subsystemOfDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.kpi.scineticle.model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("DELETE FROM user_table")
    void deleteAll();

    @Query("SELECT * FROM user_table ORDER BY name DESC")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM user_table WHERE email = :email and password = :password")
    User getUser(String email, String password);


}
