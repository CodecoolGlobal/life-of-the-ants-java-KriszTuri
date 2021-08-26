package com.codecool.ants.geometry;

import java.util.Arrays;
import java.util.Random;

import com.codecool.ants.geometry.Soldiers;


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
        //Placing the Queen
        colonyToBeFilled[centerOfColony][centerOfColony] = "Q";
        setColony(colonyToBeFilled);
    }

    public void display(String[][] array){
        System.out.println("------------------------------------");
        for (String[] x : array)
        {
            for (String y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    public void generateAnts(int numOfSoldiers, int numOfDrones, int numOfWorkers){
        Soldiers soldiers = new Soldiers();
        Drones drones = new Drones();
        Workers workers = new Workers();

        for(int i = 0; i < numOfSoldiers; i++){
            int[] randomCoordinates = randomGeneratedCoordinates();
            colony[randomCoordinates[0]][randomCoordinates[1]] = soldiers.letterForDisplay;
        }

        for(int i = 0; i < numOfDrones; i++){
            int[] randomCoordinates = randomGeneratedCoordinates();
            colony[randomCoordinates[0]][randomCoordinates[1]] = drones.letterForDisplay;
        }

        for(int i = 0; i < numOfWorkers; i++){
            int[] randomCoordinates = randomGeneratedCoordinates();
            colony[randomCoordinates[0]][randomCoordinates[1]] = workers.letterForDisplay;
        }
    }

    public int[] randomGeneratedCoordinates(){
        Random random = new Random();
        int randomCoordinate1 = random.nextInt(width - 1) + 1;
        int randomCoordinate2 = random.nextInt(width - 1) + 1;
        return new int[]{randomCoordinate1, randomCoordinate2};
    }

    public void update(){

    }

    public void act() {

    }

}
