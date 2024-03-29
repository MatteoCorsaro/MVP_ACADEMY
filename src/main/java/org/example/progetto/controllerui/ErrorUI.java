package org.example.progetto.controllerui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.progetto.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

public class ErrorUI implements Initializable {
    @FXML
    private  Label errorLbl;
    @FXML
    private Button okBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLbl.setText(Singleton.getLoginInstance().getErrorMessage());
        okBtn.setOnAction(event -> Singleton.getLoginInstance().getViewFactory().closeStage((Stage) errorLbl.getScene().getWindow()));
    }
}
