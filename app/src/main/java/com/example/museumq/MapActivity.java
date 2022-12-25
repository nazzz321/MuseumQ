package com.example.museumq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;


public class MapActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        MapView mapView = findViewById(R.id.imageViewMap);
        View bottomSheet = findViewById(R.id.bottomSheetInfo);
        TextView textView = findViewById(R.id.textViewTitle);
        BottomSheetBehavior.from(bottomSheet).addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_HIDDEN);
        BottomSheetBehavior.from(bottomSheet).setDraggable(false);
        mapView.setImage("umap.png");
        mapView.init();
        mapView.loadPointsFromFile("points.txt");
        mapView.setOnTouchMethod(new MapView.onTouchPointListener() {
            @Override
            public boolean onTouchPoint(int index) {
                if (index != -1) {
                    textView.setText(String.valueOf(mapView.getPointByIndex(index).getNumber()));
                    BottomSheetBehavior.from(bottomSheet).setDraggable(true);
                    BottomSheetBehavior.from(bottomSheet).setHideable(false);
                    BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
                }
                return false;
            }
        });
    }
}