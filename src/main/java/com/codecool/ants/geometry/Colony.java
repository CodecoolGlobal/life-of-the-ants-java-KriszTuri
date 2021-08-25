package com.codecool.ants.geometry;

import java.util.Arrays;

public class Colony {
    private int width;
    String[][] colony = new String[width][width];

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void fillColony(){
        for(String[] row: colony){
            Arrays.fill(row, "0");
        }
    }

    public void writeColony(){
        for (String[] x : colony)
        {
            for (String y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
