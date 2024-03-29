package org.example.progetto.controllerui.trainer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.example.progetto.view.TrainerReservationCellFactory;
import org.example.progetto.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageBookControllerUI implements Initializable {
    @FXML
    private ListView reservationListview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAllReservationList();
        updateListView();
    }

    private void updateListView() {
        reservationListview.setItems(Singleton.getLoginInstance().getAllReservation());
        reservationListview.setCellFactory(e->new TrainerReservationCellFactory());
    }

    private void initAllReservationList() {
        if(Singleton.getLoginInstance().getAllReservation().isEmpty()){
            Singleton.getLoginInstance().setAllReservation();
        }
    }
}
