package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class EncyclopediaArticle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encyclopedia_article);

        TextView Title = findViewById(R.id.TitleArticle);
        TextView Article = findViewById(R.id.ArticleText);
        TextView SubArticle = findViewById(R.id.SubTitleArticle);
        ImageButton buttonBack = findViewById(R.id.BackArticle);

        buttonBack.setOnClickListener(view -> {
            Intent intent = new Intent(EncyclopediaArticle.this, EncyclopediaActivity.class);
            startActivity(intent);
        });

        Title.setText(getIntent().getStringExtra("Title"));
        SubArticle.setText(getIntent().getStringExtra("SubArticle"));
        Article.setText(getIntent().getStringExtra("Article"));


    }
}