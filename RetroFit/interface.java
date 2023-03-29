package com.example.flashcallf;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitINTER {
    @POST("/androidNBLookup")
    Call<PData> executeLookup(@Body HashMap<String, String> map);

    @GET("/androidHistory")
    Call<ArrayList<PGetHistory>> executeGetHistory();
}
