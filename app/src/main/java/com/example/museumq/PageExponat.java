package com.example.museumq;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PageExponat extends AppCompatActivity {

    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_exponat);



        TextView Title = findViewById(R.id.ExponatTitle);
        TextView FirstBlocktext = findViewById(R.id.FirstBlockText);
        ImageView image = findViewById(R.id.ExponatImage);
        ImageButton cameraButton = findViewById(R.id.CameraButton);
        ImageButton arrowHide = findViewById(R.id.Hide);
        ImageButton MapButton = findViewById(R.id.MapButton);
        Button Continue = findViewById(R.id.ContinueExcursion);

        cameraButton.setOnClickListener(view -> {
            cameraButton.setImageResource(R.drawable.cameraoff);
        });

        Continue.setOnClickListener(view -> {
            Intent intent = new Intent(PageExponat.this , MapActivity.class);
            startActivity(intent);
        });

        MapButton.setOnClickListener(view -> {
            String temp = getIntent().getExtras().get("PictureMap").toString();
            Intent intent = new Intent(PageExponat.this , MapOfExponat.class);
            intent.putExtra("Picture",temp);
            startActivity(intent);
        });

        arrowHide.setOnClickListener(view -> {
            if (i%2==1){
                String temp = getIntent().getStringExtra("ArticleFirstBlock");
                FirstBlocktext.setText(temp.substring(0,200)+"...");
                i = 0;
                arrowHide.setImageResource(R.drawable.arrowhideup);
            }
            if(i%2==0){
                FirstBlocktext.setText(getIntent().getStringExtra("ArticleFirstBlock"));
                arrowHide.setImageResource(R.drawable.arrowhidedown);
                i = 1;
            }
        });

        Title.setText(getIntent().getStringExtra("Title"));
        String temp = getIntent().getStringExtra("ArticleFirstBlock");
        FirstBlocktext.setText(temp.substring(0,200)+"...");
        image.setBackgroundResource(Integer.parseInt(getIntent().getExtras().get("Picture").toString()));


    }
}