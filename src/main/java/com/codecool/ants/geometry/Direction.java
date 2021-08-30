package com.codecool.ants.geometry;

import java.util.Random;

public enum Direction {
        NORTH, EAST, SOUTH, WEST;

    public static Direction getRandomDirection() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }

    public static String getName(Direction randomDirection){
        return randomDirection.name();
    }
}

