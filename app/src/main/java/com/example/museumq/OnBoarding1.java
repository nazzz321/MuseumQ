package com.example.museumq;

import androidx.annotation.StringDef;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OnBoarding1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_1);

        TextView textView = findViewById(R.id.TextIntroduce);
        Button button = (Button) findViewById(R.id.OnBoardingButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            textView.setText("Текст, разъясняющий, как работает приложение\n" +
                    "Текст, разъясняющий, как работает приложение\n" +
                    "Текст, разъясняющий, как работает приложение\n" +
                    "Текст, разъясняющий, как работает приложение\n" +
                    "Текст, разъясняющий, как работает приложение");
            }
        });

    }
}