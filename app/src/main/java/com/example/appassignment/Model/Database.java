package com.example.appassignment.Model;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;


@androidx.room.Database(entities = {Weather.class}, version = 1)
public abstract class Database extends RoomDatabase {

    private static Database instance;
    public abstract Dao weatherDao();

    public static synchronized Database getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    Database.class, "database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
