package com.codecool.ants.geometry;

public class Position {

    public int x;
    public int y;
    public final String antName;

    public Position(int x, int y, String antName) {
        this.x = x;
        this.y = y;
        this.antName = antName;
    }

    public int[] getPosition(){
        return new int[]{this.x, this.y};
    }

    public void printData(){
        System.out.println(this.antName+"'s position: "+ this.x+","+this.y);
    }

    public void changePosition(int x, int y){
        this.x = x;
        this.y = y;
    }
}