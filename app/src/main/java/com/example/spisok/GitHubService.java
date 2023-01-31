package com.example.spisok;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

    // GET /repos/:owner/:repo/contributors

    @GET("/users/:username")
    Call<List<Contributor>> repoContributors(
            @Path("username") String username;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
