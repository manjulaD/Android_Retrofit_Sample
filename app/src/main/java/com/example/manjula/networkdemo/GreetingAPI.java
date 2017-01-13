package com.example.manjula.networkdemo;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Manjula on 1/8/2017.
 */
public interface GreetingAPI {

    @GET("greeting")
    Call<Greeting> getGreeting(@Query("tagged") String tags);
}