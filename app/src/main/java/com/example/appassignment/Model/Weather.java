package com.example.appassignment.Model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "weather_table")
public class Weather {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String name;
    private String temp_c;
    private String last_updated;
    private String wind_kph;
    private String wind_dir;
    private String humidity;
    private String cloud;
    private String feelslike_c;

    public Weather(String name,String temp_c, String feelslike_c, String wind_kph, String wind_dir, String humidity, String cloud, String last_updated){
        this.name = name;
        this.temp_c = temp_c;
        this.feelslike_c = feelslike_c;
        this.wind_kph = wind_kph;
        this.wind_dir = wind_dir;
        this.humidity = humidity;
        this.cloud = cloud;
        this.last_updated = last_updated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp_c;
    }

    public void setTemp(String temp) {
        this.temp_c = temp_c;
    }

    public String getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(String temp_c) {
        this.temp_c = temp_c;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(String wind_kph) {
        this.wind_kph = wind_kph;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(String feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
