package org.example.progetto.secondcontrollerui.athlete;

import org.example.progetto.SingletonSecondView;
import org.example.progetto.bean.AthleteBean;
import org.example.progetto.controller.athlete.HomeControllerApp;

import java.io.PrintStream;
import java.text.SimpleDateFormat;

public class AthleteAccountControllerUI {
    private static final String EMPTY ="-----";

    public void start() {
        PrintStream printer = SingletonSecondView.getLoginInstance().getPrinterStream();
        HomeControllerApp controllerApp = new HomeControllerApp();
        printer.println(STR."Username: \{SingletonSecondView.getLoginInstance().getUser().getUsername()}");
        AthleteBean athleteBean = controllerApp.retAppToUi(SingletonSecondView.getLoginInstance().getUser());

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

        SingletonSecondView.getLoginInstance().getViewFactory().exitAthlete();
    }
}
