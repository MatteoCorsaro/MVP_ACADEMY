package org.example.progetto.controllerui.trainer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import org.example.progetto.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

import static org.example.progetto.constant.TrainerMenuOption.STATS;
import static org.example.progetto.constant.TrainerMenuOption.BOOK;
import static org.example.progetto.constant.TrainerMenuOption.ADD;

public class TrainerControllerUI implements Initializable {
    @FXML
    private BorderPane trainerParent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Singleton.getLoginInstance().getViewFactory().trainerSelectedMenuItemProperty().addListener(((observableValue, oldVal, newVal) -> {
            switch(newVal){
                case STATS-> trainerParent.setCenter(Singleton.getLoginInstance().getViewFactory().getStatsManageView());
                case BOOK-> trainerParent.setCenter(Singleton.getLoginInstance().getViewFactory().getBookingManageView());
                case ADD-> trainerParent.setCenter(Singleton.getLoginInstance().getViewFactory().getAddAthleteView());
                default -> trainerParent.setCenter(Singleton.getLoginInstance().getViewFactory().getTrainerHomeView());
            }
        }));
    }
}
