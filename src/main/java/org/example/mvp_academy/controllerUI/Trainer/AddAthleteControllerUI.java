package org.example.mvp_academy.controllerUI.Trainer;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AddAthleteControllerUI implements Initializable {
    public TextField fName_fld;
    public TextField lName_fld;
    public TextField Password_fld;
    public TextField Username_fld;
    public DatePicker Birth_pck;
    public TextField Position_fld;
    public TextField Team_fld;
    public Button AddAthlete_btn;
    public Text error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
