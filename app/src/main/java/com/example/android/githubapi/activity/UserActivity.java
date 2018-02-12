package com.example.android.githubapi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.githubapi.R;
import com.example.android.githubapi.model.GitHubUser;
import com.example.android.githubapi.rest.APIClient;
import com.example.android.githubapi.rest.GitHubUserEndPoints;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    ImageView avatarImg;
    TextView userNameTV;
    TextView followersTV;
    TextView followingTV;
    TextView login;
    TextView email;
    Button ownedRepos;

    Bundle extras;
    String newString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        avatarImg = (ImageView) findViewById(R.id.avatar);
        userNameTV = (TextView) findViewById(R.id.user_name);
        followersTV = (TextView) findViewById(R.id.followers);
        followingTV = (TextView) findViewById(R.id.following);
        login = (TextView) findViewById(R.id.login);
        email = (TextView) findViewById(R.id.email);
        ownedRepos = (Button) findViewById(R.id.owned_repos_btn);

        extras = getIntent().getExtras();
        newString = extras.getString("STRING_I_NEED");

        System.out.println(newString);
        loadData();
    }

    private void loadData() {
        final GitHubUserEndPoints apiService = APIClient.getClient().create(GitHubUserEndPoints.class);
        Call<GitHubUser> call = apiService.getUser(newString);
        call.enqueue(new Callback<GitHubUser>(){

            @Override
            public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {
                userNameTV.setText(response.body().getName());
                followersTV.setText("Followers: " + response.body().getFollowers());
                followingTV.setText("Following: " + response.body().getFollowing());
                login.setText("Login: " + response.body().getLogin());
                email.setText("Email: " + response.body().getEmail());
            }

            @Override
            public void onFailure(Call<GitHubUser> call, Throwable t) {
                System.out.println("Failed!" + t.toString());
            }
        });
    }
}
