package org.example.mvp_academy.controllerUI.Athlete;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import org.example.mvp_academy.other.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

import static org.example.mvp_academy.View.AthleteMenuOption.STATS;
import static org.example.mvp_academy.View.AthleteMenuOption.BOOK;

public class AthleteControllerUI implements Initializable {
    public BorderPane athlete_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Singleton.getLoginInstance().getViewFactory().athleteSelectedMenuItemProperty().addListener(((observableValue, oldVal, newVal) -> {
            switch(newVal){
                case STATS->athlete_parent.setCenter(Singleton.getLoginInstance().getViewFactory().getStatsView());
                case BOOK->athlete_parent.setCenter(Singleton.getLoginInstance().getViewFactory().getBookingView());
                default ->athlete_parent.setCenter(Singleton.getLoginInstance().getViewFactory().getHomeView());
            }
        }));
    }
}
