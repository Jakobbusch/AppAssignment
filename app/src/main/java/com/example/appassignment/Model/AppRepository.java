package com.example.appassignment.Model;

import android.app.Application;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class    AppRepository {

    private Dao dao;
    private static AppRepository instance;
    private MutableLiveData<Weather> weather;
    private LiveData<List<Weather>> allWeathers;


    private static class InsertWeathersAsync extends AsyncTask<Weather,Void,Void> {
        private Dao dao;

        private InsertWeathersAsync(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Weather... weathers) {
            dao.insert(weathers[0]);
            return null;
        }
    }

    private static class DeleteAllWeathersAsync extends AsyncTask<Void,Void,Void> {
        private Dao dao;

        private DeleteAllWeathersAsync(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllNotes();
            return null;
        }
    }


    private AppRepository(Application application){
        weather = new MutableLiveData<>();
        Database database = Database.getInstance(application);
        dao = database.weatherDao();
        allWeathers = dao.getAllWeathers();
    }

    public static synchronized AppRepository getInstance(Application application){
        if(instance == null){
            instance = new AppRepository(application);
        }
        return instance;
    }
    public LiveData<List<Weather>> getAllWeathers(){
        return allWeathers;
    }

    public void insert(Weather weather) {
        new InsertWeathersAsync(dao).execute(weather);
    }
    public void deleteAllNotes(){
        new DeleteAllWeathersAsync(dao).execute();
    }

    public LiveData<Weather> getWeather(){
        return weather;
    }

    public void updateTest(String city){

        API api = ServiceGenerator.getAPI();
        Call<APIResponse> call = api.getWeather("a224e30996f54e5abd3130015201711",city);

        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                if (response.code() == 200){
                    weather.setValue(response.body().getWeather());
                }

                if (response.code() == 401){
                    Log.i("API", "API key not provided.");
                }

                if (response.code() == 400){
                    Log.i("API", "\tNo location found matching parameter 'q'");
                }

                if (response.code() == 403){
                    Log.i("API", "API key has exceeded calls per month quota.");
                }


            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                Log.i("Retrofit2", "Something is wrong in the API!");
                t.getMessage();
                t.printStackTrace();
                t.getCause();

            }
        });
    }
}
