package com.codecool.ants.geometry;

public class Workers extends Ants{
    public final String letterForDisplay = "W";

    public void setMovePattern(){
        this.movePattern = Direction.getName(Direction.getRandomDirection());
    }

    public void setName(String name){
        this.name = name;
    }
}
