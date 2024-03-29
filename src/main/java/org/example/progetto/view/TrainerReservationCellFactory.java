package org.example.progetto.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.example.progetto.bean.ReservationBean;
import org.example.progetto.controllerui.trainer.TrainerReservationAccCellControllUI;
import org.example.progetto.controllerui.trainer.TrainerReservationCellControllerUI;
import org.example.progetto.Singleton;
import org.example.progetto.exception.MyException;

public class TrainerReservationCellFactory extends ListCell<ReservationBean>{
    @Override
    protected void updateItem(ReservationBean reservation, boolean empty) {
        super.updateItem(reservation, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = null;
            try {
                if(reservation.getState().equals("NON ACCETTATA")){
                    loader = new FXMLLoader(getClass().getResource("/org/example/mvp_academy/Trainer/ReservationCell.fxml"));
                    TrainerReservationCellControllerUI controllerUI = new TrainerReservationCellControllerUI(reservation);
                    loader.setController(controllerUI);
                }else {
                    loader = new FXMLLoader(getClass().getResource("/org/example/mvp_academy/Trainer/AcceptedReservationCell.fxml"));
                    TrainerReservationAccCellControllUI controllerUI = new TrainerReservationAccCellControllUI(reservation);
                    loader.setController(controllerUI);
                }
            } catch (Exception e) {
                Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            }

            setText(null);
            try {
                if (loader != null) {
                    setGraphic(loader.load());
                }
            } catch (Exception e) {
                MyException ex = new MyException();
                ex.exceptionDB(e);
            }
        }
    }
}
