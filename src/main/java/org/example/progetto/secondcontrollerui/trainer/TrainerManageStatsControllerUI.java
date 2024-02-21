package org.example.progetto.secondcontrollerui.trainer;

import org.example.progetto.SingletonSecondView;

import java.io.PrintStream;
import java.util.Scanner;

public class TrainerManageStatsControllerUI {
    public void start() {
        PrintStream printer = SingletonSecondView.getLoginInstance().getPrinterStream();

        printer.println("\n\tANCORA DA IMPLEMENTARE");
        SingletonSecondView.getLoginInstance().getViewFactory().exitTrainer();
    }
}
