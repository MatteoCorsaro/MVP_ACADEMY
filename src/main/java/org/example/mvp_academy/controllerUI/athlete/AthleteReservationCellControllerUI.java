package org.example.mvp_academy.controllerUI.athlete;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.mvp_academy.Singleton;
import org.example.mvp_academy.bean.ReservationBean;
import org.example.mvp_academy.controllerAPP.athlete.AthleteReservationCellControllerApp;

import java.net.URL;
import java.util.ResourceBundle;

public class AthleteReservationCellControllerUI implements Initializable{
    @FXML
    private Label reservationDateLbl;
    @FXML
    private Label reservationHourLbl;
    @FXML
    private Label trainerNameLbl;
    @FXML
    private Button removeLbl;
    @FXML
    private Label acceptLbl;

    private final ReservationBean reservation;

    public AthleteReservationCellControllerUI(ReservationBean reservation) {
        this.reservation = reservation;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AthleteReservationCellControllerApp controllerApp=new AthleteReservationCellControllerApp();
        reservationDateLbl.setText(controllerApp.retDateReservation(reservation));
        reservationHourLbl.setText(controllerApp.retHourReservation(reservation));
        trainerNameLbl.setText(controllerApp.retTrainerNameReservation(reservation));
        try {
            acceptLbl.setText(controllerApp.retStateReservation(reservation));
        } catch (Exception e) {
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }
        getRemoveLbl().setOnAction(event -> {
            try {
                controllerApp.remove(reservation);
            } catch (Exception e) {
                Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            }
        });
    }
    public void setReservationDateLbl(String s) {
        this.reservationDateLbl.setText(s);
    }

    public void setReservationHourLbl(String s) {
        this.reservationHourLbl.setText(s);
    }

    public void setTrainerNameLbl(String s) {
        this.trainerNameLbl.setText(s);
    }

    public Button getRemoveLbl() {
        return removeLbl;
    }

    public void setAcceptLbl(String s) {
        this.acceptLbl.setText(s);
    }
}
