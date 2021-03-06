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

    public int centerOfColony() {
        return (int) Math.floor((double)width/2);
    }

/**Creates the colony, fills it with *s, places the Queen in the middle**/
    public void fillColony(){
        String[][] colonyToBeFilled = new String[width][width];

        for (int i = 0; i < width; i++) {
            for(int j =0; j < colonyToBeFilled[i].length; j++){
                Arrays.fill(colonyToBeFilled[i], "*");
            }
        }
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

    public int[] antSpecificGeneratedCoordinates(String movePattern, Ants ant, Queen queen){
        int[] coordinates;
        int[] currentCoordinates = ant.getPosition();
        switch (movePattern) {
            case "patrol":
                coordinates = new int[]{0, 0};
                break;
            case "approachQueen":
                //TODO: check x, move x, if it's = Queen x -> check y, move y
                int[] queensPosition = queen.getPosition();
                coordinates = new int[]{1, 1};
                break;
            case "NORTH":
                coordinates = new int[]{currentCoordinates[0]+1, currentCoordinates[1]};
                break;
            case "EAST":
                coordinates = new int[]{currentCoordinates[0], currentCoordinates[1]+1};
                break;
            case "WEST":
                coordinates = new int[]{currentCoordinates[0], currentCoordinates[1]-1};
                break;
            case "SOUTH":
                coordinates = new int[]{currentCoordinates[0]-1, currentCoordinates[1]};
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + movePattern);
        }
        return coordinates;
    }

    /**Generates soldiers, drones and workers, places them in the colony array.**/
    public void generateAnts(int numOfSoldiers, int numOfDrones, int numOfWorkers){
        //Placing the Queen
        Queen queen = new Queen();
        int centerOfColony = centerOfColony();
        int[] position = {centerOfColony, centerOfColony};
        colony[centerOfColony][centerOfColony] = queen.letterForDisplay;
        queen.setPosition(position);

        for(int i=0; i<numOfSoldiers; i++){
            Soldiers soldier = new Soldiers();
            soldier.setName("Soldier nr. "+(i+1));
            soldier.setMovePattern("patrol");
            placeAnt(soldier, soldier.letterForDisplay, "random");
        }

        for(int i=0; i<numOfDrones; i++){
            Drones drone = new Drones();
            drone.setName("Drone nr. "+(i+1));
            drone.setMovePattern("approachQueen");
            placeAnt(drone, drone.letterForDisplay, "random");
        }

        for(int i=0; i<numOfWorkers; i++){
            Workers worker = new Workers();
            worker.setName("Worker nr. "+(i+1));
            worker.setMovePattern();
            placeAnt(worker, worker.letterForDisplay, "random");
        }

    }

    /**Checks generated coordinate - if it's already occupied, generates a new one and checks that one as well**/
    private void placeAnt(Ants ant, String letterForDisplay, String methodOfPlacement) {
        int[] generatedCoordinates = new int[0];

        if(methodOfPlacement.equals("random")){
                generatedCoordinates = randomGeneratedCoordinates();
        }

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

    public void moveAnt(Ants ant, Queen queen){
        int[] oldPosition = ant.getPosition();
        int[] newPosition = antSpecificGeneratedCoordinates(ant.movePattern, ant, queen);
        ant.setPosition(newPosition);
    }


}
