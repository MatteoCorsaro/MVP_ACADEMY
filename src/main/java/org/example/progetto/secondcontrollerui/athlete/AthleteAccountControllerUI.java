package org.example.progetto.secondcontrollerui.athlete;

import org.example.progetto.Singleton;
import org.example.progetto.SingletonSecondView;
import org.example.progetto.bean.AthleteBean;
import org.example.progetto.controller.athlete.HomeControllerApp;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AthleteAccountControllerUI {
    private static final String EMPTY ="-----";

    public void start() {
        PrintStream printer = SingletonSecondView.getLoginInstance().getPrinterStream();
        HomeControllerApp controllerApp = new HomeControllerApp();
        printer.println(STR."Username: \{Singleton.getLoginInstance().getUser().getUsername()}");
        AthleteBean athleteBean = controllerApp.retAppToUi(Singleton.getLoginInstance().getUser());

        printer.println(STR."Name: \{athleteBean.getName()}");
        printer.println(STR."Surname: \{athleteBean.getSurname()}");
        printer.println(STR."Team: \{athleteBean.getTeam()}");
        printer.println(STR."Position: \{athleteBean.getPosition().toString()}");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedString = formatter.format(athleteBean.getDateOfBirth());

        if(athleteBean.getDateOfBirth()==null){
            printer.println(STR."Birth: \{EMPTY}");
        }else {
            printer.println(formattedString);
        }
        printer.println(STR."Height: \{EMPTY}");
        printer.println(STR."Weight: \{EMPTY}");
        printer.println(STR."Phone: \{EMPTY}");



        printer.println("\n\tSELEZIONA COSA VUOI FARE");

        int choice;
        printer.println("\n\n1.->TORNARE AL MENU");
        printer.println("\n2.->LOGOUT");

        Scanner input = new Scanner(System.in);

        label:
        while (true) {
            printer.println("Please, make a choice(enter a number between 1 and 2): ");

            choice = input.nextInt();
            switch (choice) {
                case 1:
                    SingletonSecondView.getLoginInstance().getViewFactory().showAthleteMenu();
                    break label;
                case 2:
                    SingletonSecondView.getLoginInstance().getViewFactory().logout();
                    break label;
                default:
                    printer.println("Not valid choice!");
                    break;
            }

        }
    }
}
