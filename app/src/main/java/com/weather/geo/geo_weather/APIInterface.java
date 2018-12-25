package com.weather.geo.geo_weather;

import com.weather.geo.geo_weather.model.ForcastModel;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

        @GET("data/2.5/forecast?APPID=4599bf9d6841bf44861d8317c2c06e0d&")
        Call<ForcastModel>getWeatherForcast(@Query("q") String current_location);
}
