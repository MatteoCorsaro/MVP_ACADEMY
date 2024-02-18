package org.example.mvp_academy.controllerUI.Trainer;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.example.mvp_academy.View.T_reservationCellFactory;
import org.example.mvp_academy.other.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageBookControllerUI implements Initializable {
    public ListView reservation_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAllReservationList();
        updateListView();
    }

    private void updateListView() {
        reservation_listview.setItems(Singleton.getLoginInstance().getAllReservation());
        reservation_listview.setCellFactory(e->new T_reservationCellFactory());
    }

    private void initAllReservationList() {
        if(Singleton.getLoginInstance().getAllReservation().isEmpty()){
            Singleton.getLoginInstance().setAllReservation();
        }
    }
}
