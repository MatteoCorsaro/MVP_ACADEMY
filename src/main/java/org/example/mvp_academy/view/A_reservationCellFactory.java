package org.example.mvp_academy.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.example.mvp_academy.bean.ReservationBean;
import org.example.mvp_academy.controllerUI.Athlete.A_ReservationCellControllerUI;

public class A_reservationCellFactory extends ListCell<ReservationBean>{
    @Override
    protected void updateItem(ReservationBean reservation,boolean empty) {
        super.updateItem(reservation, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/mvp_academy/Athlete/ReservationCell.fxml"));
            A_ReservationCellControllerUI controllerUI = new A_ReservationCellControllerUI(reservation);
            loader.setController(controllerUI);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
