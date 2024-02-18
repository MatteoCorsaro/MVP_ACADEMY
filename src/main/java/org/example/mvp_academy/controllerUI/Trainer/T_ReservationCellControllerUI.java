package org.example.mvp_academy.controllerUI.Trainer;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.mvp_academy.Bean.ReservationBean;
import org.example.mvp_academy.controllerAPP.Trainer.T_ReservationCellControllerApp;
import org.example.mvp_academy.other.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

public class T_ReservationCellControllerUI implements Initializable {
    public Label name_lbl;
    public Label Date_lbl;
    public Label Hour_lbl;
    public Button accept_btn;
    public Button delete_btn;

    private final ReservationBean reservation;

    public T_ReservationCellControllerUI(ReservationBean reservation) {
        this.reservation = reservation;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        T_ReservationCellControllerApp controllerApp=new T_ReservationCellControllerApp();

        name_lbl.setText(controllerApp.ret_Name_reservation(reservation));
        Date_lbl.setText(controllerApp.ret_date_reservation(reservation));
        Hour_lbl.setText(controllerApp.ret_hour_reservation(reservation));

        accept_btn.setOnAction(event -> {
            try {
                controllerApp.accept(reservation);
            } catch (Exception e) {
                Singleton.getLoginInstance().setError_message(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            }
        });
        delete_btn.setOnAction(event -> {
            try {
                controllerApp.remove(reservation);
            } catch (Exception e) {
                Singleton.getLoginInstance().setError_message(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            }
        });
    }
}
