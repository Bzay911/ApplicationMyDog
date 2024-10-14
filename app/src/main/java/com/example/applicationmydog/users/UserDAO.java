package com.example.applicationmydog.users;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM USER")
    LiveData <List<User>>findAll();

    @Query("SELECT * FROM USER WHERE ID = :id")
    User findById(Integer id);

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    LiveData<User> getUserByEmailAndPassword(String email, String password);
}
