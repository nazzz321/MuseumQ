package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class Greetings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);
        ImageButton next = findViewById(R.id.imageButton2);
        next.setOnClickListener(view -> {
            Intent intent = new Intent(Greetings.this,MenuActivity.class);
            startActivity(intent);
        });
    }
}