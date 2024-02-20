package org.example.mvpAcademy.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.example.mvpAcademy.bean.ReservationBean;
import org.example.mvpAcademy.controllerUI.athlete.AthleteReservationCellControllerUI;

public class AthleteReservationCellFactory extends ListCell<ReservationBean>{
    @Override
    protected void updateItem(ReservationBean reservation,boolean empty) {
        super.updateItem(reservation, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/mvpAcademy/Athlete/ReservationCell.fxml"));
            AthleteReservationCellControllerUI controllerUI = new AthleteReservationCellControllerUI(reservation);
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
