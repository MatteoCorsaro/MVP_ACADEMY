package org.example.progetto.secondcontrollerui.trainer;

import org.example.progetto.SingletonSecondView;
import org.example.progetto.SelectChoice;

import java.io.PrintStream;

public class TrainerMenuControllerUI extends SelectChoice {
    public void start() {
        PrintStream printer = SingletonSecondView.getLoginInstance().getPrinterStream();

        printer.println("\n\t---*SELECT ACCOUNT TYPE*---");

        printer.println("\n\n1.->HOME ACCOUNT");
        printer.println("2.->MANAGE BOOK");
        printer.println("3.->MANAGE STATS");
        printer.println("4.->ADD PLAYER");
        printer.println("5.->LOGOUT");

        int choice=makeChoice(1,5,printer);

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
