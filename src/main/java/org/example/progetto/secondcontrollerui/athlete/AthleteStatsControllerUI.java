package org.example.progetto.secondcontrollerui.athlete;

import org.example.progetto.SingletonSecondView;

import java.io.PrintStream;

public class AthleteStatsControllerUI {

    public void start() {
        PrintStream printer = SingletonSecondView.getLoginInstance().getPrinterStream();
        printer.println("ANCORA DA IMPLEMENTARE");
        printer.println("\n-----------------------------------------------------------------------");
        SingletonSecondView.getLoginInstance().getViewFactory().exitAthlete();
    }

}
