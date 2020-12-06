package com.example.appassignment.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Insert
    void insert(Weather weather);

    @Update
    void update(Weather weather);

    @Delete
    void delete(Weather weather);

    @Query("DELETE FROM weather_table")
    void deleteAllNotes();

    @Query("SELECT * FROM weather_table")
    LiveData<List<Weather>> getAllWeathers();

}

