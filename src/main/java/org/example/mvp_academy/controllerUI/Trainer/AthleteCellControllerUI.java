package org.example.mvp_academy.controllerUI.Trainer;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.mvp_academy.Bean.AthleteBean;

import java.net.URL;
import java.util.ResourceBundle;

public class AthleteCellControllerUI implements Initializable {
    public Label name_lbl;
    public Label lastName_lbl;
    public Label Birth_lbl;
    public Label Position_lbl;
    public Label Team_lbl;
    public Label Phone_lbl;
    public Button delete_btn;



    public AthleteCellControllerUI(AthleteBean athleteBean){
        /*Costruttore che popula le varie label*/
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
