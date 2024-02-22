package org.example.progetto.secondview;

import org.example.progetto.SingletonSecondView;
import org.example.progetto.secondcontrollerui.LoginControllerUI;
import org.example.progetto.secondcontrollerui.athlete.*;
import org.example.progetto.secondcontrollerui.trainer.*;
import org.example.progetto.constant.AccountType;

import java.io.PrintStream;
import java.util.Scanner;

public class SecondViewFactory {
    private AccountType loginAccountType;

    public SecondViewFactory(){
        this.loginAccountType= AccountType.ATHLETE;
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public void showLoginWindow(){
        LoginControllerUI secondLog=new LoginControllerUI();
        secondLog.start();
    }

    /*--------- MENU---------*/
    public void showAthleteMenu() {
        AthleteMenuControllerUI secondAthleteMenu=new AthleteMenuControllerUI();
        secondAthleteMenu.start();
    }

    public void showTrainerMenu() {
        TrainerMenuControllerUI secondTrainerMenu=new TrainerMenuControllerUI();
        secondTrainerMenu.start();
    }

    /*--------- ATHLETE SCENE---------*/
    public void showAthleteAccount() {
        AthleteAccountControllerUI secondController =new AthleteAccountControllerUI();
        secondController.start();
    }
    public void showAthleteBook() {
        AthleteBookControllerUI secondController = new AthleteBookControllerUI();
        secondController.start();
    }

    public void showAthleteStats() {
        AthleteStatsControllerUI secondController = new AthleteStatsControllerUI();
        secondController.start();
    }

    public void exitAthlete(){
        PrintStream printer =SingletonSecondView.getLoginInstance().getPrinterStream();

        printer.println("\n\tSELEZIONA COSA VUOI FARE");

        int choice;
        printer.println("\n\n1.->TORNARE AL MENU");
        printer.println("\n2.->LOGOUT");

        Scanner input = new Scanner(System.in);
        boolean b=true;
        while (b) {
            printer.println("Please, make a choice(enter a number between 1 and 2): ");

            choice = input.nextInt();
            if (choice == 1) {
                SingletonSecondView.getLoginInstance().getViewFactory().showAthleteMenu();
                b=false;
            } else if (choice == 2) {
                SingletonSecondView.getLoginInstance().getViewFactory().logout();
                b=false;
            } else {
                printer.println("Not valid choice!");
            }
        }
    }

    public void showAthleteBookManage() {
        AthleteManageBookControllerUI secondController = new AthleteManageBookControllerUI();
        secondController.start();
    }
    /*--------- TRAINER SCENE---------*/
    public void showTrainerAccount() {
        TrainerHomeControllerUI secondController = new TrainerHomeControllerUI();
        secondController.start();
    }

    public void showTrainerBook() {
        TrainerManageBookControllerUI secondController = new TrainerManageBookControllerUI();
        secondController.start();
    }

    public void showTrainerStats() {
        TrainerManageStatsControllerUI secondController = new TrainerManageStatsControllerUI();
        secondController.start();
    }
    public void showTrainerAddAthlete() {
        TrainerAddAthleteControllerUI secondController = new TrainerAddAthleteControllerUI();
        secondController.start();
    }

    public void exitTrainer(){
        PrintStream printer =SingletonSecondView.getLoginInstance().getPrinterStream();

        printer.println("\n\tSELEZIONA COSA VUOI FARE");

        int choice;
        printer.println("\n\n1.->TORNARE AL MENU");
        printer.println("\n2.->LOGOUT");

        Scanner input = new Scanner(System.in);
        boolean b=true;
        while (b) {
            printer.println("Please, make a choice(enter a number between 1 and 2): ");

            choice = input.nextInt();
            if (choice == 1) {
                SingletonSecondView.getLoginInstance().getViewFactory().showTrainerMenu();
                b=false;
            } else if (choice == 2) {
                SingletonSecondView.getLoginInstance().getViewFactory().logout();
                b=false;
            } else {
                printer.println("Not valid choice!");
            }
        }
    }

    /*-----ON LOGOUT---------------------*/
    public void logout() {
        SingletonSecondView.getLoginInstance().getPrinterStream().println("A PRESTO.");
        System.exit(0);
    }


}
