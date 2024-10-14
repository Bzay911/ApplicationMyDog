package com.example.applicationmydog.ui.main;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DogDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Dog dog);

   @Update
   void update(Dog dog);

    @Delete
    void delete(Dog dog);

    @Query("SELECT * FROM DOG")
    LiveData<List<Dog>> findAll();

    @Query("SELECT * FROM DOG WHERE ID = :id")
    Dog findById(int id);



}
