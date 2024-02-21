package org.example.progetto.secondcontrollerui.athlete;

import org.example.progetto.SingletonSecondView;
import org.example.progetto.SelectChoice;

import java.io.PrintStream;

public class AthleteMenuControllerUI extends SelectChoice {
    public void start() {
        PrintStream printer = SingletonSecondView.getLoginInstance().getPrinterStream();
        printer.println("-----------------------------------------------------------------------");
        printer.println("\n\t---*SELECT ACCOUNT TYPE*---");

        printer.println("\n\n1.->HOME ACCOUNT");
        printer.println("2.->BOOK");
        printer.println("3.->STATS");
        printer.println("4.->YOUR RESERVATION");
        printer.println("5.->LOGOUT");

        int choice= makeChoice(1,5,printer);

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
                SingletonSecondView.getLoginInstance().getViewFactory().showAthleteBookManage();
                break;
            case 5:
                SingletonSecondView.getLoginInstance().getViewFactory().logout();
                break;
            default:
                printer.println("ERROR: Athlete choice menu");
                break;
        }
    }
}
