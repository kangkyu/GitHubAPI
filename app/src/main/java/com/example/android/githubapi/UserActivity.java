package com.example.android.githubapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UserActivity extends AppCompatActivity {

    Bundle extras;
    String newString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        extras = getIntent().getExtras();
        newString = extras.getString("STRING_I_NEED");

        System.out.println(newString);
    }
}
