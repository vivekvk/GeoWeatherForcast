package com.weather.geo.geo_weather;
/*
 * Copyright (C) 2018 Stack Labs, Inc - All Rights Reserved.
 * Contents of this file are proprietary and confidential.
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 */

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.logging.HttpLoggingInterceptor;

public class APIClient {


    private static Retrofit retrofit = null;
    static String BASE_URL = "http://api.openweathermap.org/";

    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();



        return retrofit;
    }

}
