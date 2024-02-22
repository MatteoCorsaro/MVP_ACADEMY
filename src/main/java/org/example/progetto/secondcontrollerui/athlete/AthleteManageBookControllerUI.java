package org.example.progetto.secondcontrollerui.athlete;


import org.example.progetto.SingletonSecondView;
import org.example.progetto.bean.ReservationBean;
import org.example.progetto.controller.athlete.AthleteReservationCellControllerApp;

import java.io.PrintStream;
import java.util.ArrayList;


public class AthleteManageBookControllerUI {
    private final ArrayList<ReservationBean> listBook;

    public  AthleteManageBookControllerUI(){
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
        SingletonSecondView.getLoginInstance().getPrinterStream().println("\n-----------------------------------------------------------------------");
        SingletonSecondView.getLoginInstance().getViewFactory().exitAthlete();
    }

    private void printReservation(ReservationBean reservation) {
        AthleteReservationCellControllerApp controllerApp=new AthleteReservationCellControllerApp();
        PrintStream printer = SingletonSecondView.getLoginInstance().getPrinterStream();
        printer.print(controllerApp.retTrainerNameReservation(reservation));
        printer.print(" | ");
        printer.print(controllerApp.retDateReservation(reservation));
        printer.print(" | ");
        printer.print(controllerApp.retHourReservation(reservation));
        printer.print(" | ");
        printer.println(controllerApp.retStateReservation(reservation));
    }
}
