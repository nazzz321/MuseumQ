package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        ImageButton buttonBack = findViewById(R.id.BackCollection);
        buttonBack.setOnClickListener(view -> {
            Intent intent = new Intent(CollectionActivity.this, MenuActivity.class);
            startActivity(intent);
        });

    }
}