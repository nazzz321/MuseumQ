package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button buttonStart = (Button) findViewById(R.id.buttonStart);
        Button buttonCollection = (Button) findViewById(R.id.buttonCollection);
        Button buttonEncyclopedia = (Button) findViewById(R.id.buttonWiki);
        Log.d("CREATION", String.valueOf(buttonStart.getText()));
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, MapActivity.class);
                startActivity(intent);
            }
        });

        buttonCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Collection.class);
                startActivity(intent);
            }
        });
        buttonEncyclopedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Encyclopedia.class);
                startActivity(intent);
            }
        });
    }
}