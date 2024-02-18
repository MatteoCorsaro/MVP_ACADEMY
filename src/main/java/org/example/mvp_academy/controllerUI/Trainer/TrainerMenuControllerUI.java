package org.example.mvp_academy.controllerUI.Trainer;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.mvp_academy.View.AthleteMenuOption;
import org.example.mvp_academy.View.TrainerMenuOption;
import org.example.mvp_academy.other.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

public class TrainerMenuControllerUI implements Initializable {
    public Button home_btn;
    public Button stats_btn;
    public Button book_btn;
    public Button Add_athlete;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    private void addListeners(){

        home_btn.setOnAction(event ->onHome());
        stats_btn.setOnAction(event ->onStats());
        book_btn.setOnAction(event ->onBook());
        Add_athlete.setOnAction(event ->onAddAthlete());

        logout_btn.setOnAction(event -> onLogout());
    }
    private void onAddAthlete(){
        Singleton.getLoginInstance().getViewFactory().trainerSelectedMenuItemProperty().set(TrainerMenuOption.ADD);
    }
    private void onHome(){
        Singleton.getLoginInstance().getViewFactory().trainerSelectedMenuItemProperty().set(TrainerMenuOption.HOME);
    }
    private void onStats(){
        Singleton.getLoginInstance().getViewFactory().trainerSelectedMenuItemProperty().set(TrainerMenuOption.STATS);
    }
    private void onBook(){
        Singleton.getLoginInstance().getViewFactory().trainerSelectedMenuItemProperty().set(TrainerMenuOption.BOOK);
    }
    private void onLogout() {
        Stage stage = (Stage) home_btn.getScene().getWindow();
        // Close the client window
        Singleton.getLoginInstance().getViewFactory().closeStage(stage);
        // Show Login Window
        Singleton.getLoginInstance().getViewFactory().showLoginWindow();
    }

}
