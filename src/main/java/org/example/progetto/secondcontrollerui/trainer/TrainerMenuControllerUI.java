package org.example.progetto.secondcontrollerui.trainer;

import org.example.progetto.SingletonSecondView;

import java.io.PrintStream;
import java.util.Scanner;

public class TrainerMenuControllerUI {
    public void start() {
        PrintStream printer = SingletonSecondView.getLoginInstance().getPrinterStream();

        printer.println("\n\t---*SELECT ACCOUNT TYPE*---");

        printer.println("\n\n1.->HOME ACCOUNT");
        printer.println("2.->MANAGE BOOK");
        printer.println("3.->MANAGE STATS");
        printer.println("4.->ADD PLAYER");
        printer.println("5.->LOGOUT");

        int choice=-1;
        Scanner input = new Scanner(System.in);
        printer.println("Please, make a choice(enter a number between 1 and 5): ");
        while (choice < 1 || choice > 5) {
            if (input.hasNextInt()) {
                choice = input.nextInt();
                if (choice < 1 || choice > 5) {
                    printer.println("Not valid choice!");
                }
            } else {
                printer.println("Invalid input! Please enter a number between 1 and 5.");
                input.next(); // discard the invalid input
            }
        }

        switch (choice){
            case 1:
                SingletonSecondView.getLoginInstance().getViewFactory().showTrainerAccount();
                break;
            case 2:
                SingletonSecondView.getLoginInstance().getViewFactory().showTrainerBook();
                break;
            case 3:
                SingletonSecondView.getLoginInstance().getViewFactory().showTrainerStats();
                break;
            case 4:
                SingletonSecondView.getLoginInstance().getViewFactory().showTrainerAddAthlete();
                break;
            case 5:
                SingletonSecondView.getLoginInstance().getViewFactory().logout();
                break;
            default:
                printer.println("ERROR: Trainer choice menu");
                break;
        }
    }
}
