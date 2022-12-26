package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MapOfExponat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_of_exponat);
        TextView Title = findViewById(R.id.textView3);
        ImageView MapEx = findViewById(R.id.imageView3);
        MapEx.setBackgroundResource(Integer.parseInt(getIntent().getExtras().get("Picture").toString()));
        Title.setText(getIntent().getStringExtra("title"));

    }
}