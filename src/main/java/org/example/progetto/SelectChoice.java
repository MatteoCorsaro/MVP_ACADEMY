package org.example.progetto;

import java.io.PrintStream;
import java.util.Scanner;

public class SelectChoice {
    public int makeChoice(int min, int max, PrintStream printer){

        int choice=-1;
        Scanner input = new Scanner(System.in);
        printer.println(STR."Please, make a choice(enter a number between\{min} and \{max}): ");
        while (choice < min || choice > max) {
            if (input.hasNextInt()) {
                choice = input.nextInt();
                if (choice < 1 || choice > 4) {
                    printer.println("Not valid choice!");
                }
            } else {
                printer.println(STR."Invalid input! Please enter a number between \{min} and \{max}.");
                input.next(); // discard the invalid input
            }
        }
        return choice;
    }
}
