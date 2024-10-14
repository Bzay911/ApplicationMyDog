package com.example.applicationmydog;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.applicationmydog.ui.main.Dog;
import com.example.applicationmydog.ui.main.DogDAO;
import com.example.applicationmydog.users.User;
import com.example.applicationmydog.users.UserDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Dog.class, User.class}, version = 2, exportSchema = false)
public abstract class PersistenceRoomDatabase extends RoomDatabase {

    // declare all your DAOs
    public abstract DogDAO dogDAO();

    public abstract UserDAO userDAO();
    private static volatile PersistenceRoomDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static PersistenceRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (PersistenceRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room
                            .databaseBuilder(context.getApplicationContext(), PersistenceRoomDatabase.class, "pet_db")
                            .addCallback(roomCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            populateInitialData(INSTANCE);
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            Log.i("XYZ", "Open DB called");
        }
    };



    private static void populateInitialData(PersistenceRoomDatabase instance) {
        PersistenceRoomDatabase.databaseWriteExecutor.execute(()->{
            DogDAO dogDAO = INSTANCE.dogDAO();
            dogDAO.insert(new Dog("Tommy","" , "Missing Golden Retriever", "Male", "Golden Retriever", 2, 15, "Max"));
            dogDAO.insert(new Dog("Boxer", "", "Found black boxer", "Female", "Boxer", 3, 20, "Alex"));
            dogDAO.insert(new Dog("Sammy", "", "Missing dog named Sammy", "Male", "Husky", 2, 15, "Adam"));
        });

    }

}
