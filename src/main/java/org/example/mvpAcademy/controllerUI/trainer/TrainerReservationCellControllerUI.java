package org.example.mvpAcademy.controllerUI.trainer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.mvpAcademy.bean.ReservationBean;
import org.example.mvpAcademy.controllerAPP.trainer.TrainerReservationCellControllerApp;
import org.example.mvpAcademy.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

public class TrainerReservationCellControllerUI implements Initializable {
    @FXML
    private Label nameLbl;
    @FXML
    private Label dateLbl;
    @FXML
    private Label hourLbl;
    @FXML
    private Button acceptBtn;
    @FXML
    private Button deleteBtn;

    private final ReservationBean reservation;

    public TrainerReservationCellControllerUI(ReservationBean reservation) {
        this.reservation = reservation;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TrainerReservationCellControllerApp controllerApp=new TrainerReservationCellControllerApp();

        nameLbl.setText(controllerApp.retNameReservation(reservation));
        dateLbl.setText(controllerApp.retDateReservation(reservation));
        hourLbl.setText(controllerApp.retHourReservation(reservation));

        acceptBtn.setOnAction(event -> {
            try {
                controllerApp.accept(reservation);
            } catch (Exception e) {
                Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            }
        });
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
