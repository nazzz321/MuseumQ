package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class EncyclopediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encyclopedia);
        ImageButton buttonBack = findViewById(R.id.BackArticle);
        Button Okunev = findViewById(R.id.OkunevCulture);
        Button Tagarskya = findViewById(R.id.TagarskyCulture);

        buttonBack.setOnClickListener(view -> {
            Intent intent = new Intent(EncyclopediaActivity.this, MenuActivity.class);
            startActivity(intent);
        });

        Okunev.setOnClickListener(view -> {
            Intent intent = new Intent(EncyclopediaActivity.this, EncyclopediaArticle.class);

            intent.putExtra("Title", Okunev.getText().toString());
            intent.putExtra("SubArticle", "");
            intent.putExtra("Article",getResources().getString(R.string.Okunev_culture_articletext));

            startActivity(intent);
        });

        Tagarskya.setOnClickListener(view -> {
            Intent intent = new Intent(EncyclopediaActivity.this, EncyclopediaArticle.class);

            intent.putExtra("Title", Tagarskya.getText().toString());
            intent.putExtra("SubArticle", "");
            intent.putExtra("Article",getResources().getString(R.string.Tagarskaya_culture_articletext));

            startActivity(intent);

        });


    }
}