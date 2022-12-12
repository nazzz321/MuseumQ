package com.example.museumq;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;

import java.io.IOException;
import java.io.InputStream;

public class MapView extends androidx.appcompat.widget.AppCompatImageView {

    private Bitmap mapBitmap;
    private Drawable drawableMap;
    private float imageWidth, imageHeight;
    public Exhibits exs;
    public MapView(Context context) {
        super(context);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public void Init(String pathImage){
        try(InputStream inputStream = getContext().getAssets().open(pathImage)) {
            mapBitmap = BitmapFactory.decodeStream(inputStream);
            drawableMap = new BitmapDrawable(mapBitmap);
            imageWidth = mapBitmap.getWidth();
            imageHeight = mapBitmap.getHeight();

            this.setImageDrawable(drawableMap);

        }
        catch (IOException e){
            e.printStackTrace();
        }
        exs = new Exhibits();
        exs.addEx(new Exhibit(40.f, 620.f, 73));
        exs.addEx(new Exhibit(40.f, 510.f, 84));
        exs.addEx(new Exhibit(40.f, 425.f, 68));
        exs.addEx(new Exhibit(40.f, 305.f, 64));
        exs.addEx(new Exhibit(157.f, 545.f, 55));
        exs.addEx(new Exhibit(157.f, 457.f, 58));
    }
    public int getExp(MotionEvent event){
        return exs.isHit(
                ((imageWidth / this.getWidth()) * event.getX()),
                ((imageHeight / this.getHeight()) * event.getY()),
                20
        );
    }
}
