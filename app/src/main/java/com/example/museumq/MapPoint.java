package com.example.museumq;

public class MapPoint {
    private float x;
    private float y;
    private int number;

    public float getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }
    public int getNumber(){
        return this.number;
    }
    public boolean setX(float x){
        this.x = x;
        return true;
    }
    public boolean setY(float x){
        this.y = y;
        return true;
    }
    public boolean setNumber(int number){
        this.number = number;
        return true;
    }
    public MapPoint(float x, float y, int number){
        this.x = x;
        this.y = y;
        this.number = number;
    }
}
