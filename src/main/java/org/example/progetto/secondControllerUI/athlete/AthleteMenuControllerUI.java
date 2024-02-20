package org.example.progetto.secondControllerUI.athlete;

import org.example.progetto.SingletonSecondView;

import java.io.PrintStream;
import java.util.Scanner;

public class AthleteMenuControllerUI {
    public void start() {
        PrintStream printer = SingletonSecondView.getLoginInstance().getPrinterStream();

        printer.println("\n\t---*SELECT ACCOUNT TYPE*---");

        printer.println("\n\n1.->HOME ACCOUNT");
        printer.println("2.->BOOK");
        printer.println("3.->STATS");
        printer.println("4.->LOGOUT");

        int choice=-1;
        Scanner input = new Scanner(System.in);
        printer.println("Please, make a choice(enter a number between 1 and 4): ");
        while (choice < 1 || choice > 4) {
            if (input.hasNextInt()) {
                choice = input.nextInt();
                if (choice < 1 || choice > 4) {
                    printer.println("Not valid choice!");
                }
            } else {
                printer.println("Invalid input! Please enter a number between 1 and 4.");
                input.next(); // discard the invalid input
            }
        }

        switch (choice){
            case 1:
                SingletonSecondView.getLoginInstance().getViewFactory().showAthleteAccount();
                break;
            case 2:
                SingletonSecondView.getLoginInstance().getViewFactory().showAthleteBook();
                break;
            case 3:
                SingletonSecondView.getLoginInstance().getViewFactory().showAthleteStats();
                break;
            case 4:
                SingletonSecondView.getLoginInstance().getViewFactory().logout();
                break;
            default:
                printer.println("ERROR: Athlete choice menu");
                break;
        }
    }
}
