package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGHT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView image =findViewById(R.id.imageView3);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        image.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {

            @Override

            public void run() {


                Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);

                SplashScreen.this.startActivity(mainIntent);

                SplashScreen.this.finish();
                }
            }, SPLASH_DISPLAY_LENGHT);

    }
    }
