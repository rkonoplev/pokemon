package org.example;

import java.util.Scanner;

/**
 * Main program to run the Pokémon catching simulation.
 */
public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input directions using symbols N, S, E, O (for example, NSNNO): ");
        String insertedString = input.nextLine();
        input.close();

        // Validate the path
        char[] wayClean = DirectionReceiver.directionCheck(insertedString);

        // Calculate number of captured Pokémon
        int pokemonSum = HunterMoving.hunterMoving(wayClean);
        System.out.println("Number of Pokémon is: " + pokemonSum);
    }
}
