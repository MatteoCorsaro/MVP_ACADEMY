package org.example.progetto.controllerui.trainer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.progetto.bean.ReservationBean;
import org.example.progetto.controller.trainer.TrainerReservationCellControllerApp;
import org.example.progetto.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

public class TrainerReservationAccCellControllUI implements Initializable {
    @FXML
    private Label nameLbl;
    @FXML
    private Label dateLbl;
    @FXML
    private Label hourLbl;
    @FXML
    private Button deleteBtn;

    private final ReservationBean reservation;

    public TrainerReservationAccCellControllUI(ReservationBean reservation) {
        this.reservation = reservation;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TrainerReservationCellControllerApp controllerApp=new TrainerReservationCellControllerApp();

        nameLbl.setText(controllerApp.retNameReservation(reservation));
        dateLbl.setText(controllerApp.retDateReservation(reservation));
        hourLbl.setText(controllerApp.retHourReservation(reservation));

        deleteBtn.setOnAction(event -> {
            try {
                controllerApp.remove(reservation);
            } catch (Exception e) {
                Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            }
        });
    }
}
