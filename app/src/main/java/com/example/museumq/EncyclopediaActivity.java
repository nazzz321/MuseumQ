package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class EncyclopediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encyclopedia);
        ImageButton buttonBack = findViewById(R.id.BackEncyclopedia);
        Button Okunev = findViewById(R.id.OkunevCulture);

        buttonBack.setOnClickListener(view -> {
            Intent intent = new Intent(EncyclopediaActivity.this, MenuActivity.class);
            startActivity(intent);
        });

        Okunev.setOnClickListener(view -> {


            Intent intent = new Intent(EncyclopediaActivity.this, EncyclopediaArticle.class);
            intent.putExtra("Title", Okunev.getText().toString());
            intent.putExtra("SubArticle", "Hello");

            intent.putExtra("Article",R.    );
            startActivity(intent);
        });
    }
}