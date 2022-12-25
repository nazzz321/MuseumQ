package com.example.museumq;

import android.graphics.PointF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MapPoints {

    private ArrayList<MapPoint> mapPoints = new ArrayList<MapPoint>();
    public boolean addPoint(MapPoint ex){
        this.mapPoints.add(ex);
        return true;
    }
    public boolean deletePointByIndex(int index){
        this.mapPoints.remove(index);
        return true;
    }
    public MapPoint getPointByIndex(int index){
        return this.mapPoints.get(index);
    }
    public int size(){
        return mapPoints.size();
    }
    // Return index point, if dist to point < r
    public int findNearPoint(PointF p, float r){
        float dist;
        for (int index = 0; index < mapPoints.size(); index++){
            dist = getDistPoint2MPoint(p, mapPoints.get(index));
            if (dist < r)
                return index;
        }
        return -1;
    }
    public float getDistPoint2MPoint(PointF p, MapPoint mp){
        return (float)Math.sqrt(Math.pow((p.x - mp.getX()), 2) + Math.pow((p.y - mp.getY()), 2));
    }
    public float getDistMPoint2MPoint(MapPoint mp1, MapPoint mp2){
        return (float)Math.sqrt(Math.pow((mp1.getX() - mp2.getX()), 2) + Math.pow((mp1.getY() - mp2.getY()), 2));
    }
}
