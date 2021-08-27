package com.codecool.ants;
import com.codecool.ants.geometry.Colony;

import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {
        //System.out.println("You can use `mvn package; java -jar target/ants-1.0.jar` to run this app from the console");
        Colony c = new Colony();
        Scanner getUserInput = new Scanner(System.in);
        System.out.println("Colony size? ");
        int userWidth = getUserInput.nextInt();
        if(userWidth%2==0){
            System.out.println("Irregular numbers only.");
        }
        else{
            c.setWidth(userWidth);
            c.fillColony();
        }
        c.generateAnts(2,3,4);
        c.display(c.getColony());
    }

}
