package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class EncyclopediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encyclopedia);
        ImageButton buttonBack = findViewById(R.id.BackEncyclopedia);
        buttonBack.setOnClickListener(view -> {
            Intent intent = new Intent(EncyclopediaActivity.this, MenuActivity.class);
            startActivity(intent);
        });
    }
}