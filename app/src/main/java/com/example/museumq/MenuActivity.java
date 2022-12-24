package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    SharedPreferences settings;
    SharedPreferences.Editor settingsEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        settings = getSharedPreferences("Settings",0);
        settingsEditor = settings.edit();

        Button buttonStart = findViewById(R.id.buttonStart);
        Button buttonCollection = findViewById(R.id.buttonCollection);
        Button buttonEncyclopedia = findViewById(R.id.buttonWiki);
        Button buttonSettings = findViewById(R.id.buttonSettings);
        Log.d("CREATION", String.valueOf(buttonStart.getText()));
        buttonStart.setOnClickListener(view -> {
            Intent mapActivity = new Intent(MenuActivity.this, MapActivity.class);
            startActivity(mapActivity);
        });

        buttonCollection.setOnClickListener(view -> {
                    Intent CollectionActivity = new Intent(MenuActivity.this, CollectionActivity.class);
                    startActivity(CollectionActivity);
        });

        buttonEncyclopedia.setOnClickListener(view -> {
            Intent encyclopediaActivity = new Intent(MenuActivity.this, EncyclopediaActivity.class);
            startActivity(encyclopediaActivity);
        });

        buttonSettings.setOnClickListener(view -> {
            Intent settingActivity = new Intent(MenuActivity.this, SettingsActivity.class);
            startActivity(settingActivity);
        });

    }
}