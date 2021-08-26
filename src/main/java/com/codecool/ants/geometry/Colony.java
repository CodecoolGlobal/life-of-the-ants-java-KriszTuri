package com.codecool.ants.geometry;

import java.util.Arrays;
import java.util.Scanner;

public class Colony {
    private int width;

    private String[][] colony;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String[][] getColony() {
        return colony;
    }

    public void setColony(String[][] colony) {
        this.colony = colony;
    }

    public void fillColony(){
        String[][] colonyToBeFilled = new String[width][width];
        int centerOfColony = (int) Math.floor((double)width/2);
        for (int i = 0; i < width; i++) {
            for(int j =0; j < colonyToBeFilled[i].length; j++){
                Arrays.fill(colonyToBeFilled[i], "*");
            }
        }
        colonyToBeFilled[centerOfColony][centerOfColony] = "Q";
        setColony(colonyToBeFilled);
    }

    public void printColony(String[][] array){
        for (String[] x : array)
        {
            for (String y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

}
