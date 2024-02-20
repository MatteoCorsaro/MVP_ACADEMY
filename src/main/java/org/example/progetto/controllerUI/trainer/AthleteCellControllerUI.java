package org.example.progetto.controllerUI.trainer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.progetto.bean.AthleteBean;

import java.net.URL;
import java.util.ResourceBundle;

public class AthleteCellControllerUI implements Initializable {
    @FXML
    private Label nameLbl;
    @FXML
    private Label lastNameLbl;
    @FXML
    private Label birthLbl;
    @FXML
    private Label positionLbl;
    @FXML
    private Label teamLbl;
    @FXML
    private Label phoneLbl;
    @FXML
    private Button deleteBtn;



    public AthleteCellControllerUI(AthleteBean athleteBean){
        /*Costruttore che popula le varie label*/
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*ANCORA DA IMPLEMENTARE*/
    }
}
