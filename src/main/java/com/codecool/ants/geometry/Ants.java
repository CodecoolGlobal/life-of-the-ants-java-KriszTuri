package com.codecool.ants.geometry;

public abstract class Ants {
    public String name;
    public String letterForDisplay;
    public String movePattern;

    public int x;
    public int y;

    public void setPosition(int[] position){
        this.x = position[0];
        this.y = position[1];
    }

    public void printAntData(){
        System.out.println("Name: "+ this.name +
                " position: "+this.x+","+this.y +
                " move pattern: "+this.movePattern);
    }
}
