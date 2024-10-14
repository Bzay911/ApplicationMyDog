package com.example.applicationmydog;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.applicationmydog.ui.main.Dog;
import com.example.applicationmydog.users.User;
import com.example.applicationmydog.users.UserDAO;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class UserRepository {

    private PersistenceRoomDatabase db;
    private UserDAO userDAO;

    private User user;

    private LiveData<List<User>> allUsers;

    public UserRepository(Application application) {
        db = PersistenceRoomDatabase.getDatabase(application);
        userDAO = db.userDAO();
        allUsers = userDAO.findAll();
    }

    public void insert(User user){
        PersistenceRoomDatabase.databaseWriteExecutor.execute(()->{
            userDAO.insert(user);
        });
    }

    public void update(User user){
        PersistenceRoomDatabase.databaseWriteExecutor.execute(()->{
            userDAO.update(user);
        });
    }

    public void delete(User user){
        PersistenceRoomDatabase.databaseWriteExecutor.execute(()->{
            userDAO.delete(user);
        });
    }

    public LiveData<List<User>> getAllUsers(){
       return allUsers;
    }

    public User findById(int id){
        Callable c = ()->{
          User user = userDAO.findById(id);
          return user;
        };

        Future <User> future = PersistenceRoomDatabase.databaseWriteExecutor.submit(c);
        try{
            user = future.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public LiveData<User> getUserByEmailAndPassword(String email, String password) {
        return userDAO.getUserByEmailAndPassword(email, password);
    }
}
