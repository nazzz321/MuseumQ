package com.example.museumq;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapView extends androidx.appcompat.widget.AppCompatImageView {
    private MapPoints mapPoints;
    private Bitmap mapBitmap;
    private Drawable mapDrawble;
    private onTouchPointListener srv_onTouchPoint;
    private float mapWidth, mapHeight;
    private Matrix matrix = new Matrix();
    private Matrix savedMatrix = new Matrix();
    private PointF startPosition = new PointF();
    private PointF mid = new PointF();
    private float[] matrixValue = new float[9];
    static final int NONE = 0;
    static final int DRAG = 1;
    static final int ZOOM = 2;
    int mode = NONE;
    float oldDist = 1f;
    float scale;


    public MapView(Context context) {
        super(context);
    }
    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public interface onTouchPointListener{
        boolean onTouchPoint(int index);
    }
    public boolean setOnTouchMethod(onTouchPointListener l){
        this.srv_onTouchPoint = l;
        return true;
    }
    public void init(){
        mapPoints = new MapPoints();
    }
    public boolean init(MapPoints ps){
        this.mapPoints = ps;
        return true;
    }
    public boolean addPoint(MapPoint p){
        mapPoints.addPoint(p);
        return true;
    }
    public boolean deletePoint(int index){
        mapPoints.deletePointByIndex(index);
        return true;
    }
    public MapPoint getPointByIndex(int index){
        return mapPoints.getPointByIndex(index);
    }
    public boolean loadPointsFromFile(String path){
        try(InputStream inStream = getContext().getAssets().open(path)) {
            InputStreamReader inStreamReader = new InputStreamReader(inStream);
            BufferedReader bufferedReader = new BufferedReader(inStreamReader);
            String recString;
            while ((recString = bufferedReader.readLine()) != null) {
                addPoint(new MapPoint(
                        Float.parseFloat(recString.split(" ")[0]),
                        Float.parseFloat(recString.split(" ")[1]),
                        Integer.parseInt(recString.split(" ")[2])

                ));
            }
        }
        catch (IOException e){
            Log.d("STATE", "ERROR!");
        }
        Log.d("STATE",String.valueOf(mapPoints.size()));
        return true;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                matrix.set(this.getImageMatrix());
                savedMatrix.set(matrix);
                startPosition.set(event.getX(), event.getY());
                mode = DRAG;
                break;
            case MotionEvent.ACTION_POINTER_DOWN:

                oldDist = spacing(event);
                if (oldDist > 5f) {
                    savedMatrix.set(matrix);
                    midPoint(mid, event);
                    mode = ZOOM;
                }
                break;
            case MotionEvent.ACTION_UP:
                matrix.getValues(matrixValue);
                int pointNumber = mapPoints.findNearPoint(getCordOnMapImage(new PointF(event.getX(), event.getY())), 30f);
                srv_onTouchPoint.onTouchPoint(pointNumber);
                break;
            case MotionEvent.ACTION_POINTER_UP:
                mode = NONE;
                break;

            case MotionEvent.ACTION_MOVE:
                if (mode == DRAG) {
                    savedMatrix.getValues(matrixValue);
                    matrix.set(savedMatrix);
                    matrix.postTranslate(event.getX() - startPosition.x, event.getY() - startPosition.y);
                }
                else if (mode == ZOOM){
                    float newDist = spacing(event);
                    if (newDist > 5f)
                    {
                        matrix.set(savedMatrix);
                        scale = newDist / oldDist;
                        matrix.postScale(scale, scale, mid.x, mid.y);
                    }
                }
                break;
        }
        this.setImageMatrix(matrix);
        return true;
    }
    private void midPoint(PointF point, MotionEvent event)
    {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);
    }
    private float spacing(MotionEvent event)
    {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }
    private PointF getCordOnMapImage(PointF p){
        Log.d("STATE", String.valueOf((p.x - matrixValue[2]) / matrixValue[0]));
        return new PointF(
                (p.x - matrixValue[2]) / matrixValue[0],
                (p.y - matrixValue[5]) / matrixValue[4]
        );
    }
    public void setImage(String imagePath){
        try(InputStream inputStream = getContext().getAssets().open(imagePath)) {
            mapBitmap = BitmapFactory.decodeStream(inputStream);
            mapDrawble = new BitmapDrawable(getContext().getResources(), mapBitmap);
            mapWidth = mapBitmap.getWidth();
            mapHeight = mapBitmap.getHeight();
            this.setImageDrawable(mapDrawble);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
