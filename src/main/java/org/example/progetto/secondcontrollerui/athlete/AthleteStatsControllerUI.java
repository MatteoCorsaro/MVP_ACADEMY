package org.example.progetto.secondcontrollerui.athlete;

import org.example.progetto.SingletonSecondView;

public class AthleteStatsControllerUI {

    public void start() {
        SingletonSecondView.getLoginInstance().getViewFactory().exitAthlete();
    }

}
