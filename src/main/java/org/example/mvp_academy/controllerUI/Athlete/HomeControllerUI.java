package org.example.mvp_academy.controllerUI.Athlete;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.example.mvp_academy.Bean.AthleteBean;
import org.example.mvp_academy.Bean.ReservationBean;
import org.example.mvp_academy.View.A_reservationCellFactory;
import org.example.mvp_academy.controllerAPP.Athlete.HomeControllerApp;
import org.example.mvp_academy.other.Singleton;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class HomeControllerUI implements Initializable {
    public Label name_lbl;
    public Label Weight_lbl;
    public Label Pos_lbl;
    public Label Email_lbl;
    public Label Phone_lbl;
    public Label Surname_lbl;
    public Label Height_lbl;
    public Label Team_lbl;
    public Label Birth_lbl;
    public Label lbl_user_name;
    public ListView <ReservationBean> Reservation_ListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HomeControllerApp controllerApp = new HomeControllerApp();
        lbl_user_name.setText(Singleton.getLoginInstance().getUser().getUsername());
        AthleteBean athleteBean = controllerApp.ret_app_to_ui(Singleton.getLoginInstance().getUser());

        name_lbl.setText(athleteBean.getName());
        Surname_lbl.setText(athleteBean.getSurname());
        Team_lbl.setText(athleteBean.getTeam());
        Pos_lbl.setText(athleteBean.getPosition().toString());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedString = formatter.format(athleteBean.getDate_of_birth());

        if(athleteBean.getDate_of_birth()==null){
            Birth_lbl.setText("-----");
        }else {
            Birth_lbl.setText(formattedString);
        }
        Height_lbl.setText("-----");
        Weight_lbl.setText("-----");
        Phone_lbl.setText("-----");
        Email_lbl.setText("-----");
/*
        initAllReservationList();
        updateListView();*/
    }/*
    private void updateListView() {
        Reservation_ListView.setItems(Singleton.getLoginInstance().getLatestReservation());
        Reservation_ListView.setCellFactory(e->new A_reservationCellFactory());
    }

    private void initAllReservationList() {
        if(Singleton.getLoginInstance().getLatestReservation().isEmpty()){
            Singleton.getLoginInstance().setLatestReservation();
        }
    }*/
}
