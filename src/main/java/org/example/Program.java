package org.example;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input direction using symbols N, S, E, O (for example, NSNNO): ");
        String insertedString = input.nextLine();
        input.close();


        // Get the way of hunter and check it
        DirectionReceiver directionReceiver = new DirectionReceiver();
        char[] wayClean;
        wayClean = DirectionReceiver.directionCheck(insertedString);

        //Full number of captured Pokemon
        HunterMoving hunterMoving = new HunterMoving();
        int pokemonSum = HunterMoving.hunterMoving(wayClean);
        System.out.print("Number of Pokemon is:" + pokemonSum);



    }
}