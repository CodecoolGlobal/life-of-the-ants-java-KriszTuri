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
        c.setWidth(userWidth);
        c.fillColony();
        c.writeColony();
    }

}
