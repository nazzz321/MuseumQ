package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OnboardActivity extends AppCompatActivity {
    int clickCount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);


        clickCount = 0;
        Button buttonNext = findViewById(R.id.buttonNext);
        TextView textViewTitle = findViewById(R.id.textViewTitle);
        TextView textViewSubtitle = findViewById(R.id.textViewSubtitle);
        buttonNext.setOnClickListener(view -> {
            clickCount++;
            if (clickCount == 1){
                textViewTitle.setText(getResources().getString(R.string.OnboardTitle2));
                textViewSubtitle.setText(getResources().getString(R.string.OnboardSubtitle2));
            }
            if (clickCount == 2)
                finish();
        });
    }
}