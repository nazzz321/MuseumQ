package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor prefEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        pref = getSharedPreferences("Settings", 0);
        prefEditor = pref.edit();
        Button buttonKillOnboard = findViewById(R.id.buttonKill);
        buttonKillOnboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefEditor.putInt("isFirstStart", -1);
                prefEditor.apply();
                finish();
            }
        });

    }
}