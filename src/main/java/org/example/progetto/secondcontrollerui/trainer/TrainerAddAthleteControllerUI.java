package org.example.progetto.secondcontrollerui.trainer;

import org.example.progetto.SingletonSecondView;

import java.io.PrintStream;

public class TrainerAddAthleteControllerUI {
    public void start() {
        PrintStream printer = SingletonSecondView.getLoginInstance().getPrinterStream();

        printer.println("\n\tANCORA DA IMPLEMENTARE");

        printer.println("\n-----------------------------------------------------------------------");
        SingletonSecondView.getLoginInstance().getViewFactory().exitTrainer();
    }
}
