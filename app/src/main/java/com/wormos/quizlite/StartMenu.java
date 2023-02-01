package com.wormos.quizlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import pl.droidsonroids.gif.GifImageView;

public class StartMenu extends AppCompatActivity {

    GifImageView startQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
        startQuiz = findViewById(R.id.startquiz);
        startQuiz.setOnClickListener(view->{
            startActivity(new Intent(this,MainActivity.class));
        });

    }
}