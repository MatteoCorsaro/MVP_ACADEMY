package org.example.mvp_academy.controllerUI;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.mvp_academy.other.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

public class ErrorUI implements Initializable {
    public  Label error_lbl;
    public Button Ok_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        error_lbl.setText(Singleton.getLoginInstance().getError_message());

        Stage stage = (Stage) error_lbl.getScene().getWindow();

        Ok_btn.setOnAction(event -> Singleton.getLoginInstance().getViewFactory().closeStage(stage));
    }
}
