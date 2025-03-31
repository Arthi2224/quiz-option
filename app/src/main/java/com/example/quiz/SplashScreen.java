package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

Animation top_anim,bottom_anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        top_anim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_anim =  AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        new Handler().postDelayed(() -> {
            Intent intent=new Intent(SplashScreen.this,Register.class);
            startActivity(intent);
            finish();



        },2000);

    }
}