package com.example.museumq;

import java.util.ArrayList;
import java.util.List;

public class Exhibits {
    private ArrayList<Exhibit> exhibits = new ArrayList<Exhibit>();
    public int addEx(Exhibit ex){
        this.exhibits.add(ex);
        return 0;
    }
    public Exhibit getEx(int index){
        return this.exhibits.get(index);
    }
    public int deleteEx(int index){
        this.exhibits.remove(index);
        return 0;
    }
    public int isHit(float x, float y, float radius){
        for (int i = 0; i < exhibits.size(); i++){
            if (lenghtToEx(x, y, this.getEx(i)) <= radius) {
                return getEx(i).number;
            }
        }
        return -1;
    }
    private float lenghtToEx(float x, float y, Exhibit ex){
        return (float)Math.sqrt(Math.pow((x - ex.x), 2) + Math.pow((y - ex.y), 2));
    }
}
