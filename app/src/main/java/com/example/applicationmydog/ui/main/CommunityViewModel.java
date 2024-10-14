package com.example.applicationmydog.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.applicationmydog.DogRepository;

import java.util.List;

public class CommunityViewModel extends AndroidViewModel {

    private DogRepository dogRepository;
    private LiveData<List<Dog>> allDogs;
    public CommunityViewModel(@NonNull Application application) {
        super(application);

        dogRepository = new DogRepository(application);

        allDogs = dogRepository.getAllDogs();
    }

    public void insert(Dog dog){
        dogRepository.insert(dog);
    }

    public void delete(Dog dog){
        dogRepository.delete(dog);
    }

    public void update(Dog dog){
        dogRepository.update(dog);
    }

    public LiveData<List<Dog>> getAllDogs(){
        return allDogs;
    }

    public Dog findById(int id) {
        return dogRepository.findById(id);
    }
}