package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;


public class MapActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        MapView mapView = findViewById(R.id.imageViewMap);
        mapView.Init("hlf1_map.png");
        mapView.setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                int number = mapView.getExp(event);
            }
            return true;
        });
    }
}