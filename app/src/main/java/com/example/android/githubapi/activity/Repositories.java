package com.example.android.githubapi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.android.githubapi.R;
import com.example.android.githubapi.adapter.ReposAdapter;
import com.example.android.githubapi.model.GitHubRepo;
import com.example.android.githubapi.rest.APIClient;
import com.example.android.githubapi.rest.GitHubRepoEndPoints;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositories extends AppCompatActivity {

    Bundle extras;
    String newString;

    TextView userNameTV;
    RecyclerView mRecyclerView;
    ReposAdapter myAdapter;
    List<GitHubRepo> myDataSource = new ArrayList<GitHubRepo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repository_screen);

        extras = getIntent().getExtras();
        newString = extras.getString("USERNAME");

        System.out.println(newString);

//        user_name_tv
//        repos_recycler_view

        userNameTV = (TextView) findViewById(R.id.user_name_tv);
        userNameTV.setText( "User: " + newString);

        mRecyclerView = (RecyclerView) findViewById(R.id.repos_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new ReposAdapter(myDataSource, R.layout.list_item_repo, getApplicationContext());
        mRecyclerView.setAdapter(myAdapter);

        loadRepositories();
    }

    public void loadRepositories() {
        final GitHubRepoEndPoints apiService = APIClient.getClient().create(GitHubRepoEndPoints.class);
        Call<List<GitHubRepo>> call = apiService.getRepos(newString);
        call.enqueue(new Callback<List<GitHubRepo>>(){
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                myDataSource.clear();
                myDataSource.addAll(response.body());
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                System.out.println("Failed!" + t.toString());
            }
        });
    }
}
