package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Project6Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Project6_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project6);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://simplifiedcoding.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Project6_MarvelApi marvelApi = retrofit.create(Project6_MarvelApi.class);

        Call<List<Project6_MarvelCharacter>> call = marvelApi.getMarvelCharacters();

        call.enqueue(new Callback<List<Project6_MarvelCharacter>>() {
            @Override
            public void onResponse(Call<List<Project6_MarvelCharacter>> call, Response<List<Project6_MarvelCharacter>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Project6_MarvelCharacter> characters = response.body();
                    adapter = new Project6_Adapter(Project6Activity.this, characters);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(Project6Activity.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Project6_MarvelCharacter>> call, Throwable t) {
                Toast.makeText(Project6Activity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}