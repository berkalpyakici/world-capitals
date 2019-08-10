package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {
    private static Capitals capitals = new Capitals();
    private static int points = 0;
    private static int lives = 3;

    public static void main(String[] args) {
        // Load countries to public variable.
        capitals.loadCountries();

        System.out.println("Welcome to the countries & capitals game!\n" +
                "I will ask you the capitals of countries across the globe.\n");

        promptQuestion();
    }

    /**
     * Randomly selects 4 cities and builds a question from one of the selected answers randomly.
     */
    private static void promptQuestion() {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);

        int [] options = new int [4];
        int question = rand.nextInt(4);

        // Select 4 random countries/cities to show them as an option.
        for(int i=0; i<4; i++) options[i] = rand.nextInt(capitals.COUNTRIES.size());

        // Printing prompts...
        System.out.println("What is the capital of "+capitals.COUNTRIES.get(options[question]).country+"?");
        for(int i=0; i<4; i++) {
            System.out.print("["+ (i+1) + "] "+capitals.COUNTRIES.get(options[i]).city+"\n");
        }

        // Parsing input...
        int option;
        do {
            System.out.print("Answer: ");
            option = Integer.parseInt(in.nextLine()) - 1;

        } while (0 > option || option > 3);

        // Answer management.
        if(option == question) {
            points += 1;
            System.out.print("\nThat's right! You gained 1 more point, and you are at " +
                    points+" point(s) with "+lives+" live(s) left!\n\n");
        } else {
            lives -= 1;
            System.out.print("\nThe right answer was "+capitals.COUNTRIES.get(options[question]).city+". " +
                    "You have "+lives+" live(s) left!\n\n");
        }

        if(lives > 0) {
            promptQuestion();
        } else {
            System.out.println("Game over! You made "+points+" point(s).");
        }
    }
}
