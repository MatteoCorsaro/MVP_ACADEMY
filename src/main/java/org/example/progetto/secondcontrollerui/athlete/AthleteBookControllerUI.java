package org.example.progetto.secondcontrollerui.athlete;

import org.example.progetto.*;
import org.example.progetto.bean.ReservationBean;
import org.example.progetto.controller.athlete.BookControllerApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AthleteBookControllerUI extends SelectChoice {

    private String trainer;
    private String hour;
    private String date;

    public void start() {
        PrintStream printer = SingletonSecondView.getLoginInstance().getPrinterStream();

        getTrainer(printer);
        getDate(printer);
        getHour(printer);

        if (date != null || trainer != null || hour != null) {
            try {
                onReservation();
                printer.println("PRENOTAZIONE SALVATA!!!");
            } catch (Exception e) {
                Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            }
        }

        SingletonSecondView.getLoginInstance().getViewFactory().exitAthlete();
    }


    private void onReservation() {
        BookControllerApp controllerApp = new BookControllerApp();
        ReservationBean reservationBean = controllerApp.getThisReservation(this.trainer,this.date,this.hour, SingletonSecondView.getLoginInstance().getUser().getUsername());
        if (controllerApp.savePrenotation(reservationBean)) {
            SingletonSecondView.getLoginInstance().addReservation(reservationBean);
        }
    }


    private void getDate(PrintStream printer) {
        printer.println("IMMETTI UNA DATA:");

        printer.println(STR."(in questo formato \"dd-MMM-yyyy\" es:\{getTodaysDate()})");
        String date;
        while(true){
            date=retString(printer,SingletonSecondView.getLoginInstance().getReaderStream());
            if (isCorretFormat(date)) {
                this.date = date;
                break;
            }else{
                printer.println("INVALID INPUT");
            }
        }
    }

    private boolean isCorretFormat(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        dateFormat.setLenient(false);

        try {
            Date date = dateFormat.parse(dateString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    private void getTrainer(PrintStream printer) {
        printer.println("SELSEZIONA UN ALLENATORE TRA I SEGUENTI:");
        String[] trainers = {TRAINER_LIST.EMANUELE.toString(), TRAINER_LIST.MATTIA.toString(), TRAINER_LIST.MASSIMILIANO.toString()};
        for (String t : trainers) {
            printer.print(STR."\{t}-");
        }
        printer.println();
        String allenatore;
        while(true){
            allenatore=retString(printer,SingletonSecondView.getLoginInstance().getReaderStream());
            if (allenatore.equalsIgnoreCase("EMANUELE") || allenatore.equalsIgnoreCase("MATTIA") || allenatore.equalsIgnoreCase("MASSIMILIANO")) {
                this.trainer = allenatore;
                break;
            }else{
                printer.println("INVALID INPUT");
            }
        }
    }

    private void getHour(PrintStream printer) {
        printer.println("SELSEZIONA UN ORARIO TRA I SEGUENTI:");
        String[] hours = {HOUR.PRIMA.toString(), HOUR.SECONDA.toString(), HOUR.TERZA.toString(), HOUR.QUARTA.toString()};
        for (String h : hours) {
            printer.print(STR."\{h} ");
        }
        printer.println();
        String orario;
        while(true){
            orario=retString(printer,SingletonSecondView.getLoginInstance().getReaderStream());
            if (orario.equalsIgnoreCase("8:00") || orario.equalsIgnoreCase("9:15") || orario.equalsIgnoreCase("10:30") || orario.equalsIgnoreCase("11:45")) {
                this.hour = orario;
                break;
            }else{
                printer.println("INVALID INPUT");
            }
        }
        //--------------------------------------------------
    }

    public String retString(PrintStream printer, BufferedReader reader){
        try {
            return reader.readLine();
        } catch (IOException e) {
            printer.println(e);
            return "";
        }
    }
    public static String getTodaysDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = new Date();
        return formatter.format(date);
    }
}
