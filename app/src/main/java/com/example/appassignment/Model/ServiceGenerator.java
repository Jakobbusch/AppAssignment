package com.example.appassignment.Model;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("http://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static API api = retrofit.create(API.class);

    public static API getAPI() {
        return api;
    }

    public Call<APIResponse> getWeather(String key, String city) {
        return null;
    }
}
