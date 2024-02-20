package org.example.progetto.secondControllerUI;

import org.example.progetto.SingletonSecondView;
import org.example.progetto.bean.UserBean;
import org.example.progetto.controllerAPP.LoginController;
import org.example.progetto.view.AccountType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class LoginControllerUI {

    public void start(){
        PrintStream printer= SingletonSecondView.getLoginInstance().getPrinterStream();
        BufferedReader reader=SingletonSecondView.getLoginInstance().getReaderStream();

        printer.println("\n\t---*SELECT ACCOUNT TYPE*---");

        SelectAccountType(printer);

        IsertCred(printer,reader);
        if(SingletonSecondView.getLoginInstance().getUser().getAccountType()== AccountType.ATHLETE){
            SingletonSecondView.getLoginInstance().getViewFactory().showAthleteMenu();
        } else if (SingletonSecondView.getLoginInstance().getUser().getAccountType() == AccountType.TRAINER){
            SingletonSecondView.getLoginInstance().getViewFactory().showTrainerMenu();
        }else{
            printer.println("ERRRORRRRE");
        }

    }
    private boolean checkLog(UserBean cred){
        LoginController loginController=new LoginController();
        return loginController.login(cred);
    }

    public void SelectAccountType(PrintStream printer){
        int choice;

        printer.println("\n\n1.->ATHLETE");
        printer.println("\n2.->TRAINER");

        Scanner input = new Scanner(System.in);

        while (true) {
            printer.println("Please, make a choice(enter a number between 1 and 2): ");

            choice = input.nextInt();
            if (choice == 1){
                SingletonSecondView.getLoginInstance().getViewFactory().setLoginAccountType(AccountType.ATHLETE);
                break;
            } else if (choice == 2) {
                SingletonSecondView.getLoginInstance().getViewFactory().setLoginAccountType(AccountType.TRAINER);
                break;
            }else {
                printer.println("Not valid choice!");
            }

        }
    }
    public void IsertCred(PrintStream printer,BufferedReader reader){
        printer.println("USERNAME: ");
        String username = "";
        String password = "";
        while(true) {
            try {
                username = reader.readLine();
            } catch (IOException e) {
                printer.println(e);
            }
            printer.println("PASSWORD: ");

            try {
                password = reader.readLine();
            } catch (IOException e) {
                printer.println(e);
            }
            UserBean cred = new UserBean(username, password);
            SingletonSecondView.getLoginInstance().setUser(cred);

            if(SingletonSecondView.getLoginInstance().getViewFactory().getLoginAccountType()== AccountType.ATHLETE) {
                cred.setAccountType(AccountType.ATHLETE);
                if (checkLog(cred)) {
                    break;
                }else{
                    printer.println("INCORRECT CREDENTIALS.");
                }
            }else if(SingletonSecondView.getLoginInstance().getViewFactory().getLoginAccountType()== AccountType.TRAINER) {
                cred.setAccountType(AccountType.TRAINER);
                if (checkLog(cred)) {
                    break;
                }else{
                    printer.println("INCORRECT CREDENTIALS.");
                }
            }
        }
    }
}
