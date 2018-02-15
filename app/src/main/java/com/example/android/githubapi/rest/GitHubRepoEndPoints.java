package com.example.android.githubapi.rest;

import com.example.android.githubapi.model.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubRepoEndPoints {
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> getRepos(@Path("user") String user);
}
