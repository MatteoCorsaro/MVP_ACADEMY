package org.example.progetto.controllerui.athlete;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.progetto.constant.AthleteMenuOption;
import org.example.progetto.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

public class AthleteMenuControllerUI implements Initializable {
    @FXML
    private Button homeBtn;
    @FXML
    private Button statsBtn;
    @FXML
    private Button bookBtn;
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
        logoutBtn.setOnAction(event -> onLogout());
    }

    private void onLogout(){
        Stage stage = (Stage) homeBtn.getScene().getWindow();
        // Close the client window
        Singleton.getLoginInstance().getViewFactory().closeStage(stage);
    }

    private void onHome(){
        Singleton.getLoginInstance().getViewFactory().athleteSelectedMenuItemProperty().set(AthleteMenuOption.HOME);
    }
    private void onStats(){
        Singleton.getLoginInstance().getViewFactory().athleteSelectedMenuItemProperty().set(AthleteMenuOption.STATS);
    }
    private void onBook(){
        Singleton.getLoginInstance().getViewFactory().athleteSelectedMenuItemProperty().set(AthleteMenuOption.BOOK);
    }
}
