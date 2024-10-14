package com.example.applicationmydog.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.applicationmydog.DogRepository;

import java.util.List;

public class DogViewModel extends AndroidViewModel {

    private DogRepository dogRepository;

    private LiveData<List<Dog>> allDogs;
    public DogViewModel(@NonNull Application application) {
        super(application);
        dogRepository = new DogRepository(application);
        allDogs = dogRepository.getAllDogs();
    }
    // TODO: Implement the ViewModel

    public void insert(Dog dog){
      dogRepository.insert(dog);
    }

    public void delete(Dog dog){
        dogRepository.delete(dog);
    }

    public void update(Dog dog){dogRepository.update(dog);
    }

    public Dog findById(Integer id){
        Dog dog = dogRepository.findById(id);
        return dog;
    }

    public LiveData<List<Dog>> getAllDogs(){
        return allDogs;
    }

}