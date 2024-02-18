package org.example.mvp_academy.controllerUI.Trainer;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import org.example.mvp_academy.Bean.TrainerBean;
import org.example.mvp_academy.other.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

import static org.example.mvp_academy.View.TrainerMenuOption.STATS;
import static org.example.mvp_academy.View.TrainerMenuOption.BOOK;
import static org.example.mvp_academy.View.TrainerMenuOption.ADD;

public class TrainerControllerUI implements Initializable {
    public BorderPane trainer_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Singleton.getLoginInstance().getViewFactory().trainerSelectedMenuItemProperty().addListener(((observableValue, oldVal, newVal) -> {
            switch(newVal){
                case STATS->trainer_parent.setCenter(Singleton.getLoginInstance().getViewFactory().getStatsManageView());
                case BOOK->trainer_parent.setCenter(Singleton.getLoginInstance().getViewFactory().getBookingManageView());
                case ADD->trainer_parent.setCenter(Singleton.getLoginInstance().getViewFactory().getAddAthleteView());
                default ->trainer_parent.setCenter(Singleton.getLoginInstance().getViewFactory().getTrainerHomeView());
            }
        }));
    }
}
