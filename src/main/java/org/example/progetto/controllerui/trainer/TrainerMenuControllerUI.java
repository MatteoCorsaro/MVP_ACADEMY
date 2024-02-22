package org.example.progetto.controllerui.trainer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.progetto.constant.TrainerMenuOption;
import org.example.progetto.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

public class TrainerMenuControllerUI implements Initializable {
    @FXML
    private Button homeBtn;
    @FXML
    private Button statsBtn;
    @FXML
    private Button bookBtn;
    @FXML
    private Button addAthlete;
    @FXML
    private Button logoutBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    private void addListeners(){

        homeBtn.setOnAction(event ->onHome());
        statsBtn.setOnAction(event ->onStats());
        bookBtn.setOnAction(event ->onBook());
        addAthlete.setOnAction(event ->onAddAthlete());

        logoutBtn.setOnAction(event -> onLogout());
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
        Stage stage = (Stage) homeBtn.getScene().getWindow();
        // Close the client window
        Singleton.getLoginInstance().getViewFactory().closeStage(stage);
    }
}
