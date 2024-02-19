package org.example.mvp_academy.controllerUI.Athlete;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.mvp_academy.bean.ReservationBean;
import org.example.mvp_academy.controllerAPP.Athlete.A_ReservationCellControllerApp;

import java.net.URL;
import java.util.ResourceBundle;

public class A_ReservationCellControllerUI implements Initializable{
    public Label reservation_date_lbl;
    public Label reservation_hour_lbl;
    public Label trainer_name_lbl;
    public Button remove_lbl;
    public Label Accept_lbl;

    private final ReservationBean reservation;

    public A_ReservationCellControllerUI(ReservationBean reservation) {
        this.reservation = reservation;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        A_ReservationCellControllerApp controllerApp=new A_ReservationCellControllerApp();
        reservation_date_lbl.setText(controllerApp.ret_date_reservation(reservation));
        reservation_hour_lbl.setText(controllerApp.ret_hour_reservation(reservation));
        trainer_name_lbl.setText(controllerApp.ret_trainerName_reservation(reservation));
        try {
            Accept_lbl.setText(controllerApp.ret_state_reservation(reservation));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        remove_lbl.setOnAction(event -> {
            try {
                controllerApp.remove(reservation);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

}
