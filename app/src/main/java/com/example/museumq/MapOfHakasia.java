package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MapOfHakasia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_of_hakasia);
        ImageView maphakasia = findViewById(R.id.imageView6);
        maphakasia.setBackgroundResource(R.drawable.mapofhakasia);
    }
}