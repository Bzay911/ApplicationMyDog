package com.example.applicationmydog;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.applicationmydog.ui.main.Dog;
import com.example.applicationmydog.ui.main.DogDAO;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class DogRepository {
    private PersistenceRoomDatabase db;
    private DogDAO dogDAO;

    private Dog dog;

    private LiveData<List<Dog>> allDogs;

    public DogRepository(Application application) {
        db = PersistenceRoomDatabase.getDatabase(application);
        dogDAO = db.dogDAO();
        allDogs = dogDAO.findAll();
    }

    public void insert(Dog dog){
        PersistenceRoomDatabase.databaseWriteExecutor.execute(()->{
            dogDAO.insert(dog);
                });
    }

    public void update(Dog dog){
        PersistenceRoomDatabase.databaseWriteExecutor.execute(()->{
            dogDAO.update(dog);
        });
    }

    public void delete(Dog dog){
        PersistenceRoomDatabase.databaseWriteExecutor.execute(()->{
            dogDAO.delete(dog);
        });
    }


    public LiveData<List<Dog>> getAllDogs(){
        return allDogs;
    }


    public Dog findById(int id){
        Callable c = ()-> {
         Dog dog = dogDAO.findById(id);
         return dog;
        };



         Future<Dog> future = PersistenceRoomDatabase.databaseWriteExecutor.submit(c);
         try {
             dog = future.get();
         }
         catch (ExecutionException e) {
             throw new RuntimeException(e);
         }
         catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
         return dog;
    }
}
