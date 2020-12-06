package com.example.appassignment.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {

    @GET("current.json")
    Call<APIResponse> getWeather(@Query("key") String key,@Query("q") String city);



}
