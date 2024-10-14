package com.example.applicationmydog.users;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.applicationmydog.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepository;
    private LiveData<List<User>> allUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        allUsers = userRepository.getAllUsers();
    }
    // TODO: Implement the ViewModel

    public void insert(User user){
        userRepository.insert(user);
    };

    public void update(User user){
        userRepository.update(user);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public User findById(Integer id){
        User user = userRepository.findById(id);
        return user;
    }

    public LiveData<List<User>> getAllUsers(){
       return allUsers;
    }


    public LiveData<User>login(String email, String password) {
        return userRepository.getUserByEmailAndPassword(email, password);
    }
}