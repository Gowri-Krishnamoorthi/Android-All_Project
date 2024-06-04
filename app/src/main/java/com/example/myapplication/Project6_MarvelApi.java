package com.example.myapplication;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Project6_MarvelApi {
    @GET("https://simplifiedcoding.net/demos/marvel/")
    Call<List<Project6_MarvelCharacter>> getMarvelCharacters();
}