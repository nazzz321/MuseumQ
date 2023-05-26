package com.example.museumq;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.content.res.Resources;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class MapActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        MapView mapView = findViewById(R.id.imageViewMap);
        View bottomSheet = findViewById(R.id.bottomSheetInfo);
        TextView textView = findViewById(R.id.textViewTitle);
        ImageView imageView = findViewById(R.id.imageViewExpo);
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

                    if (14 == mapView.getPointByIndex(index).getNumber()) {
                        textView.setText("Добрые личины");

                        imageView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                Intent intent = new Intent(MapActivity.this, ImageViewerActivity.class);
                                startActivity(intent);

                                return false;
                            }
                        });
                        try(InputStream inputStream = getAssets().open("14.png")) {
                            Bitmap mapBitmap = BitmapFactory.decodeStream(inputStream);
                            BitmapDrawable mapDrawble = new BitmapDrawable(getResources(), mapBitmap);
                            float mapWidth = mapBitmap.getWidth();
                            float mapHeight = mapBitmap.getHeight();;
                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            imageView.setImageDrawable(mapDrawble);
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }
//                        Intent intent = new Intent(MapActivity.this, PageExponat.class);
//
//                        intent.putExtra("Title", "Боярская писаница");
//                        intent.putExtra("SubArticle", "");
//                        intent.putExtra("ArticleFirstBlock", getResources().getString(R.string.boyarskaya_1block));
//                        intent.putExtra("Picture", R.drawable._10_boyarskaya_pisanitsa);
//                        intent.putExtra("PictureMap", R.drawable.boyarskyamap);
//
//                        startActivity(intent);
                    }
                    if( 2 == mapView.getPointByIndex(index).getNumber()){
//                        Intent intent = new Intent(MapActivity.this, PageExponat.class);
//
//                        intent.putExtra("Title", "Трёхчастная личина");
//                        intent.putExtra("SubArticle", "");
//                        intent.putExtra("ArticleFirstBlock",getResources().getString(R.string.lichina3_1block));
//                        intent.putExtra("Picture",R.drawable._2_tryokhchastnaya_lichina_v_1);
//                        intent.putExtra("PictureMap",R.drawable.mapoflichina);
//
//                        startActivity(intent);
                    }/*if(11 == mapView.getPointByIndex(index).getNumber()){
                        Intent intent = new Intent(MapActivity.this, MapOfExponat.class);
                        intent.putExtra("Picture",R.drawable.ohotniknew);
                        startActivity(intent);
                    }*/if(12 == mapView.getPointByIndex(index).getNumber()){
                        Intent intent = new Intent(MapActivity.this, PageExponat.class);

                        intent.putExtra("Title", "Оленьи Бляхи");
                        intent.putExtra("SubArticle", "");
                        intent.putExtra("ArticleFirstBlock",getResources().getString(R.string.olenii_1block));
                        intent.putExtra("Picture",R.drawable.blyahi_oleni);
                        intent.putExtra("PictureMap",R.drawable.boyarskyamap);

                        startActivity(intent);
                    }
                    if(13 == mapView.getPointByIndex(index).getNumber()){
                        Intent intent = new Intent(MapActivity.this, PageExponat.class);

                        intent.putExtra("Title", "Оленьи Бляхи");
                        intent.putExtra("SubArticle", "");
                        intent.putExtra("ArticleFirstBlock",getResources().getString(R.string.olenii_1block));
                        intent.putExtra("Picture",R.drawable.blyahi_oleni);
                        intent.putExtra("PictureMap",R.drawable.boyarskyamap);

                        startActivity(intent);
                    }


                }
                return false;
            }
        });
    }
}