package com.example.android.githubapi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.android.githubapi.R;
import com.example.android.githubapi.adapter.ReposAdapter;

import java.util.Arrays;
import java.util.List;

public class Repositories extends AppCompatActivity {

    Bundle extras;
    String newString;

    TextView userNameTV;
    RecyclerView mRecyclerView;
    ReposAdapter myAdapter;
    List<String> myDataSource = Arrays.asList("a", "b", "c");

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
    }
}
