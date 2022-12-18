package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_1);
        TextView textViewSFirst = findViewById(R.id.textBold);
        TextView textViewSecond = findViewById(R.id.TextIntroduce);
        Button button = findViewById(R.id.OnBoardingButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == 0){
                textViewSecond.setText("Вы пройдёте по маршруту, исследуете артефакты, услышите мифы древних хакасов и увидете, как они жили");
                textViewSFirst.setText("Здесь ваш путеводитель по музею и истории Хакасии");
                i = 1;
                }
                else{
                    Intent intent = new Intent(MainActivity.this, MapActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}