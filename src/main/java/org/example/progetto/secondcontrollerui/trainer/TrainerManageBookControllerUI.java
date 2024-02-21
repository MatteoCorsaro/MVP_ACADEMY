package org.example.progetto.secondcontrollerui.trainer;

import org.example.progetto.SingletonSecondView;
import org.example.progetto.bean.ReservationBean;
import org.example.progetto.controller.trainer.TrainerReservationCellControllerApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class TrainerManageBookControllerUI {
    private final ArrayList<ReservationBean> listBook;

    public  TrainerManageBookControllerUI(){
        this.listBook = new ArrayList<>();
    }

    private void updateListView() {

        this.listBook.addAll(SingletonSecondView.getLoginInstance().getLatestReservation());
    }

    private void initAllReservationList() {
        if (SingletonSecondView.getLoginInstance().getLatestReservation().isEmpty()) {
            SingletonSecondView.getLoginInstance().setLatestReservation();
        }
    }

    public void start() {
        initAllReservationList();
        updateListView();

        int i=1;
        for (ReservationBean bean : listBook){
            SingletonSecondView.getLoginInstance().getPrinterStream().println(STR."\{i++}.");
            printReservation(bean);
        }

        SingletonSecondView.getLoginInstance().getViewFactory().exitAthlete();
    }

    private void printReservation(ReservationBean reservation) {
        TrainerReservationCellControllerApp controllerApp=new TrainerReservationCellControllerApp();
        PrintStream printer = SingletonSecondView.getLoginInstance().getPrinterStream();
        printer.print(controllerApp.retNameReservation(reservation));
        printer.print(" | ");
        printer.print(controllerApp.retDateReservation(reservation));
        printer.print(" | ");
        printer.print(controllerApp.retHourReservation(reservation));
        printer.print(" | ");
        if (reservation.getState().equals("NON ACCETTATA")){
            if(tryAccept(reservation)){
                controllerApp.accept(reservation);
            }
        }
    }

    private boolean tryAccept(ReservationBean reservation) {
        PrintStream printer = SingletonSecondView.getLoginInstance().getPrinterStream();
        printer.println("VUOI ACCETTARE QUESTA PRENOTAZIONE?");
        printer.println("(rispondi con si o no)");
        while(true){
            String rispo=retCred(printer, SingletonSecondView.getLoginInstance().getReaderStream());
            if(rispo.equals("Si")|| rispo.equals("si")){
                return true;
            } else if (rispo.equals("No")|| rispo.equals("no")) {
                return false;
            }else{
                printer.println("INVALID INPUT");
            }
        }
    }
    public String retCred(PrintStream printer, BufferedReader reader){
        try {
            return reader.readLine();
        } catch (IOException e) {
            printer.println(e);
            return "";
        }
    }
}
