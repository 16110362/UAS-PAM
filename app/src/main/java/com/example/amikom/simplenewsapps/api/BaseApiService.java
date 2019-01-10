package com.example.amikom.simplenewsapps.api;

import com.example.amikom.simplenewsapps.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Nikko Eka Saputra on 11/02/2018.
 */

public interface BaseApiService {

    @GET("/v2/top-headlines?country=id&apiKey=eca62009e11149109cb1a89b63753adb")
    Call<NewsResponse> getListNews(@Query("country") String country, @Query("category") String category, @Query("apiKey") String apiKey);

}
