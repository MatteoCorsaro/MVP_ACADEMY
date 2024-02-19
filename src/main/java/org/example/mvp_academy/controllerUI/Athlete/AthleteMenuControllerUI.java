package org.example.mvp_academy.controllerUI.Athlete;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.mvp_academy.view.AthleteMenuOption;
import org.example.mvp_academy.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

public class AthleteMenuControllerUI implements Initializable {
    public Button home_btn;
    public Button stats_btn;
    public Button book_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    private void addListeners(){
        home_btn.setOnAction(event ->onHome());
        stats_btn.setOnAction(event ->onStats());
        book_btn.setOnAction(event ->onBook());
        logout_btn.setOnAction(event -> onLogout());
    }

    private void onLogout() {
        Stage stage = (Stage) home_btn.getScene().getWindow();
        // Close the client window
        Singleton.getLoginInstance().getViewFactory().closeStage(stage);
        // Show Login Window
        Singleton.getLoginInstance().getViewFactory().showLoginWindow();
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
