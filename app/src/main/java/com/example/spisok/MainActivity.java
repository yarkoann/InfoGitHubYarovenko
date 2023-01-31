package com.example.spisok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
        final Call<User> call =
                gitHubService.getUsers("yarkoann");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                final TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(response.body().getName());
            }

            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
                final TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("Что-то пошло не так: " + throwable.getMessage());

            }
        });
    }
}

