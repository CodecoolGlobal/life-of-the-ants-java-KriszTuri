package com.codecool.ants.geometry;

import java.util.Arrays;
import java.util.Random;


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

/**Creates the colony, fills it with *s, places the Queen in the middle**/
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
        for(int i=0; i<numOfSoldiers; i++){
            Soldiers soldier = new Soldiers();
            soldier.setName("Soldier nr. "+(i+1));
            soldier.setMovePattern("patrol");
            placeAnt(soldier, soldier.letterForDisplay);
        }

        for(int i=0; i<numOfDrones; i++){
            Drones drone = new Drones();
            drone.setName("Drone nr. "+(i+1));
            drone.setMovePattern("approachQueen");
            placeAnt(drone, drone.letterForDisplay);
        }

        for(int i=0; i<numOfWorkers; i++){
            Workers worker = new Workers();
            worker.setName("Worker nr. "+(i+1));
            worker.setMovePattern();
            placeAnt(worker, worker.letterForDisplay);
        }
    }

    /**Checks generated coordinate - if it's already occupied, generates a new one and checks that one as well**/
    private void placeAnt(Ants ant, String letterForDisplay) {
            int[] generatedCoordinates = randomGeneratedCoordinates();
            boolean isCoordinateTaken = isCoordinateTaken(generatedCoordinates);
            if(!isCoordinateTaken){
                colony[generatedCoordinates[0]][generatedCoordinates[1]] = letterForDisplay;
                Position position = new Position(generatedCoordinates[0], generatedCoordinates[1], ant.name);
                ant.setPosition(position.getPosition());
                ant.printAntData();
            }
            else{
                do{
                    int[] newRandomCoordinates = randomGeneratedCoordinates();
                    isCoordinateTaken = isCoordinateTaken(newRandomCoordinates);
                    if(!isCoordinateTaken){
                        colony[newRandomCoordinates[0]][newRandomCoordinates[1]] = letterForDisplay;
                        Position position = new Position(generatedCoordinates[0], generatedCoordinates[1], ant.name);
                        ant.setPosition(position.getPosition());
                        ant.printAntData();
                    }
                }while(isCoordinateTaken);
            }
    }

    private boolean isCoordinateTaken(int[] generatedCoordinates){
        return colony[generatedCoordinates[0]][generatedCoordinates[1]] != "*";
    }

    public void act() {

    }

    public void update(){

    }

    public void moveAnt(int[] oldPosition, int[] newPosition, String[] colony, Ants ant){


    }


}
