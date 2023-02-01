package com.wormos.quizlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    TextView Question,answer1,answer2,answer3,answer4,resultBox;
    GifImageView gifImageView;
    int answer =0;
    int question = 0;
    MotionLayout motionLayout;
    MediaPlayer rightsound,wrongsound;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Question = findViewById(R.id.quizQuestion);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        resultBox = findViewById(R.id.resultbox);
        gifImageView = findViewById(R.id.gifimg);
        motionLayout = findViewById(R.id.motion_layout_question);

        setQuestion(question);
        question++;


        motionLayout.transitionToEnd();

        answer1.setOnClickListener(view -> {
            if(answer==1){
                quizResult(answer1,answer2,answer3,answer4,1);

            } else {
                quizResult(answer1,answer2,answer3,answer4,0);
            }
        });
        answer2.setOnClickListener(view -> {
            if(answer==2){
                quizResult(answer2,answer1,answer3,answer4,1);
            } else {
                quizResult(answer2,answer1,answer3,answer4,0);
            }
        });
        answer3.setOnClickListener(view -> {
            if(answer==3){
                quizResult(answer3,answer2,answer1,answer4,1);
            } else {
                quizResult(answer3,answer2,answer1,answer4,0);
            }
        });
        answer4.setOnClickListener(view -> {
            if(answer==4){
                quizResult(answer4,answer2,answer3,answer1,1);
            } else {
                quizResult(answer4,answer2,answer3,answer1,0);
            }
        });

    }

    @SuppressLint("SetTextI18n")
    public void quizResult(TextView selected, TextView other1, TextView other2, TextView other3, int sol) {
        rightsound= MediaPlayer.create(this,R.raw.right_sound);
        wrongsound=MediaPlayer.create(this,R.raw.wrongg_sound);
        if(sol==0){
            wrongsound.start();
            selected.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.red_button_style));
            other1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.white_button_style));
            other2.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.white_button_style));
            other3.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.white_button_style));
            resultBox.setText("YOU LOSE");
            resultBox.setTextColor(Color.parseColor("#f94449"));

            gifImageView.setImageResource(R.drawable.wrong);
            gifImageView.setVisibility(View.VISIBLE);
            resultBox.setVisibility(View.VISIBLE);


        } else {
            rightsound.start();
            selected.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.green_button_style));
            other1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.white_button_style));
            other2.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.white_button_style));
            other3.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.white_button_style));
            resultBox.setText("You are a smart farmer\n Congratulations!!!");
            resultBox.setTextColor(Color.parseColor("#797ef6"));
            rightsound.seekTo(6000);
            gifImageView.setImageResource(R.drawable.win);
            gifImageView.setVisibility(View.VISIBLE);
            resultBox.setVisibility(View.VISIBLE);

        }

        new Handler().postDelayed(() -> {
            motionLayout.setProgress(0);
            selected.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.white_button_style));
            other1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.white_button_style));
            other2.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.white_button_style));
            other3.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.white_button_style));
            resultBox.setVisibility(View.GONE);
            gifImageView.setVisibility(View.GONE);
            if(question==4){
                startActivity(new Intent(MainActivity.this,StartMenu.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP));
            } else {
                setQuestion(question);
            }

            rightsound.stop();
            wrongsound.stop();
            motionLayout.transitionToEnd();
            question++;
        },2000);


    }

    public void setQuestion(int number){
        answer3.setClickable(true);
        answer4.setClickable(true);
        switch(number%4){
            case 0:
                Question.setText(String.valueOf("P-1844 का साइलेज देता है, सबसे अधिक"));
                answer1.setText(String.valueOf("ड्राई मैटर + स्टार्स"));
                answer2.setText(String.valueOf("ड्राई मैटर + फाईबर"));
                answer3.setText(String.valueOf("ड्राई मैटर + प्रोद्रीन"));
                answer4.setText(String.valueOf("उपरोक्त सभी"));
                answer=4;
                break;
            case 1:
                Question.setText(String.valueOf("सबसे  बढ़िया साईलेज (आचार) किस फसल से बनता है।"));
                answer1.setText(String.valueOf("ईख"));
                answer2.setText(String.valueOf("चरी"));
                answer3.setText(String.valueOf("मक्की"));
                answer4.setText(String.valueOf("गेहूँ"));
                answer=2;
                break;
            case 2:
                Question.setText(String.valueOf("पायोनियर कम्पनी, बढ़िया साईलेज बनाने के लिए किस हाई बिड्र की सिफारिश करती है?"));
                answer1.setText(String.valueOf("P-1844"));
                answer2.setText(String.valueOf("P-1899"));
                answer3.setText(String.valueOf("P-1890"));
                answer4.setText(String.valueOf("उपरोक्त सभी"));
                answer=1;
                break;
            case 3:
                Question.setText(String.valueOf("क्या P-1844 हाईविड्र को गेहूं काटने के बाद बोज सकते हैं?"));
                answer1.setText(String.valueOf("हाँ"));
                answer2.setText(String.valueOf("नहीं"));
                answer3.setText(String.valueOf("--"));
                answer3.setClickable(false);
                answer4.setClickable(false);
                answer4.setText(String.valueOf("--"));
                answer=1;
                break;
        }
    }

}