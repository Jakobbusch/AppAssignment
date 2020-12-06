package com.example.appassignment.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.appassignment.Model.AppRepository;
import com.example.appassignment.Model.Weather;

import java.util.List;

public class AppViewModel extends AndroidViewModel {
    AppRepository repository;

    public AppViewModel(Application app){
        super(app);
        repository = AppRepository.getInstance(app);
    }

    public LiveData<Weather> getWeather(){
        return repository.getWeather();
    }

    public void updateWeather(String a){
        repository.updateTest(a);
    }

    public LiveData<List<Weather>> getAllWeathers() {
        return repository.getAllWeathers();
    }

    public void insert(final Weather weather) {
        repository.insert(weather);
    }

    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }
}
