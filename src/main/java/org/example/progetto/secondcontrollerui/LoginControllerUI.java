package org.example.progetto.secondcontrollerui;

import org.example.progetto.SingletonSecondView;
import org.example.progetto.bean.UserBean;
import org.example.progetto.controller.LoginController;
import org.example.progetto.constant.AccountType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class LoginControllerUI {

    public void start(){
        PrintStream printer= SingletonSecondView.getLoginInstance().getPrinterStream();
        BufferedReader reader=SingletonSecondView.getLoginInstance().getReaderStream();

        printer.println("\n\t---*SELECT ACCOUNT TYPE*---");

        selectAccountType(printer);

        isertCred(printer,reader);
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

    public void selectAccountType(PrintStream printer){
        int choice;

        printer.println("\n\n1.->ATHLETE");
        printer.println("\n2.->TRAINER");

        Scanner input = new Scanner(System.in);

        boolean b=true;

        while (b) {
            printer.println("Please, make a choice(enter a number between 1 and 2): ");

            choice = input.nextInt();
            if (choice == 1){
                SingletonSecondView.getLoginInstance().getViewFactory().setLoginAccountType(AccountType.ATHLETE);
                b=false;
            } else if (choice == 2) {
                SingletonSecondView.getLoginInstance().getViewFactory().setLoginAccountType(AccountType.TRAINER);
                b=false;
            }else {
                printer.println("Not valid choice!");
            }

        }
    }
    public void isertCred(PrintStream printer, BufferedReader reader){
        printer.println("USERNAME: ");
        String username = "";
        String password = "";
        boolean b = true;
        while(b) {
            username=retCred(printer,reader);
            printer.println("PASSWORD: ");

            password=retCred(printer,reader);
            UserBean cred = new UserBean(username, password);
            SingletonSecondView.getLoginInstance().setUser(cred);

            setAccType(cred);
            if (checkLog(cred)) {
                SingletonSecondView.getLoginInstance().setUser(cred);
                b=false;
            }else{
                printer.println("INCORRECT CREDENTIALS.");
            }
        }
    }
    public String retCred(PrintStream printer,BufferedReader reader){
        try {
            return reader.readLine();
        } catch (IOException e) {
            printer.println(e);
            return "";
        }
    }
    public void setAccType(UserBean cred){
        if(SingletonSecondView.getLoginInstance().getViewFactory().getLoginAccountType()== AccountType.ATHLETE) {
            cred.setAccountType(AccountType.ATHLETE);
        }else if(SingletonSecondView.getLoginInstance().getViewFactory().getLoginAccountType()== AccountType.TRAINER) {
            cred.setAccountType(AccountType.TRAINER);
        }
    }
}
