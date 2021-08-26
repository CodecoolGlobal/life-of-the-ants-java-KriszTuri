package com.codecool.ants.geometry;

import java.util.Arrays;
import java.util.Random;

import com.codecool.ants.geometry.Soldiers;


public class Colony {
    private int width;

    private String[][] colony;

    /**Getters and Setters**/
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

/**Fills the colony, places the Queen in the middle**/
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

    /**Used to display the colony on the console.**/
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

    /**Generates two random coordinates - created for cleaner coding.**/
    public int[] randomGeneratedCoordinates(){
        Random random = new Random();
        int randomCoordinate1 = random.nextInt(width - 1) + 1;
        int randomCoordinate2 = random.nextInt(width - 1) + 1;
        return new int[]{randomCoordinate1, randomCoordinate2};
    }

    /**Generates soldiers, drones and workers, places them in the colony array.**/
    public void generateAnts(int numOfSoldiers, int numOfDrones, int numOfWorkers){
        Soldiers soldiers = new Soldiers();
        Drones drones = new Drones();
        Workers workers = new Workers();

        checkCoordinates(numOfSoldiers, soldiers.letterForDisplay);

        checkCoordinates(numOfDrones, drones.letterForDisplay);

        checkCoordinates(numOfWorkers, workers.letterForDisplay);
    }

    private void checkCoordinates(int numOfSoldiers, String letterForDisplay) {
        for(int i = 0; i < numOfSoldiers; i++){
            int[] randomCoordinates = randomGeneratedCoordinates();
            boolean isCoordTaken = false;
            do{
                randomCoordinates = randomGeneratedCoordinates();
                if(colony[randomCoordinates[0]][randomCoordinates[1]]!="*"){
                    isCoordTaken = true;
                }
                else{
                    colony[randomCoordinates[0]][randomCoordinates[1]] = letterForDisplay;
                }
            } while(isCoordTaken);
        }
    }


    public void update(){

    }

    public void act() {

    }

}
