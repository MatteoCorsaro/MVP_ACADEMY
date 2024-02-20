package org.example.mvp_academy.controllerUI.athlete;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import org.example.mvp_academy.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

import static org.example.mvp_academy.view.AthleteMenuOption.STATS;
import static org.example.mvp_academy.view.AthleteMenuOption.BOOK;

public class AthleteControllerUI implements Initializable {
    @FXML
    private BorderPane athleteParent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Singleton.getLoginInstance().getViewFactory().athleteSelectedMenuItemProperty().addListener(((observableValue, oldVal, newVal) -> {
            switch(newVal){
                case STATS-> athleteParent.setCenter(Singleton.getLoginInstance().getViewFactory().getStatsView());
                case BOOK-> athleteParent.setCenter(Singleton.getLoginInstance().getViewFactory().getBookingView());
                default -> athleteParent.setCenter(Singleton.getLoginInstance().getViewFactory().getHomeView());
            }
        }));
    }
}
