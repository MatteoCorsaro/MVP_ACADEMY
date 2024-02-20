package org.example.mvp_academy.controllerUI.athlete;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.example.mvp_academy.bean.AthleteBean;
import org.example.mvp_academy.bean.ReservationBean;
import org.example.mvp_academy.controllerAPP.athlete.HomeControllerApp;
import org.example.mvp_academy.Singleton;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class HomeControllerUI implements Initializable {
    @FXML
    private Label nameLbl;
    @FXML
    private Label weightLbl;
    @FXML
    private Label posLbl;
    @FXML
    private Label emailLbl;
    @FXML
    private Label phoneLbl;
    @FXML
    private Label surnameLbl;
    @FXML
    private Label heightLbl;
    @FXML
    private Label teamLbl;
    @FXML
    private Label birthLbl;
    @FXML
    private Label lblUserName;
    @FXML
    private ListView <ReservationBean> reservationBeanListView;

    private static final String EMPTY ="-----";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HomeControllerApp controllerApp = new HomeControllerApp();
        lblUserName.setText(Singleton.getLoginInstance().getUser().getUsername());
        AthleteBean athleteBean = controllerApp.retAppToUi(Singleton.getLoginInstance().getUser());

        nameLbl.setText(athleteBean.getName());
        surnameLbl.setText(athleteBean.getSurname());
        teamLbl.setText(athleteBean.getTeam());
        posLbl.setText(athleteBean.getPosition().toString());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedString = formatter.format(athleteBean.getDateOfBirth());

        if(athleteBean.getDateOfBirth()==null){
            birthLbl.setText(EMPTY);
        }else {
            birthLbl.setText(formattedString);
        }
        heightLbl.setText(EMPTY);
        weightLbl.setText(EMPTY);
        phoneLbl.setText(EMPTY);
        emailLbl.setText(EMPTY);
    }
}
