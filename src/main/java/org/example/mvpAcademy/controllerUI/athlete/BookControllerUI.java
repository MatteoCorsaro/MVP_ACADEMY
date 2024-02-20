package org.example.mvpAcademy.controllerUI.athlete;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import org.example.mvpAcademy.bean.ReservationBean;
import org.example.mvpAcademy.view.AthleteReservationCellFactory;
import org.example.mvpAcademy.controllerAPP.athlete.BookControllerApp;
import org.example.mvpAcademy.HOUR;
import org.example.mvpAcademy.Singleton;
import org.example.mvpAcademy.TRAINER_LIST;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class BookControllerUI implements Initializable {
    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<String> hourChoice;
    @FXML
    private Button confirmBtn;
    @FXML
    private ChoiceBox<String> trainerChoice;
    @FXML
    private ListView<ReservationBean> listBook;

    private String trainer;
    private String hour;
    private String date;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAllReservationList();
        updateListView();

        datePicker.setOnAction(this::gatDate);

        String[] trainers={TRAINER_LIST.EMANUELE.toString(),TRAINER_LIST.MATTIA.toString(),TRAINER_LIST.MASSIMILIANO.toString()};
        trainerChoice.getItems().addAll(trainers);
        trainerChoice.setOnAction(this::getTrainer);

        String[] hours={HOUR.PRIMA.toString(),HOUR.SECONDA.toString(),HOUR.TERZA.toString(),HOUR.QUARTA.toString()};
        hourChoice.getItems().addAll(hours);
        hourChoice.setOnAction(this::getHour);

        if(datePicker !=null || trainer!=null || hour!=null){
            confirmBtn.setOnAction(event -> {
                try {
                    onReservation();
                } catch (Exception e) {
                    Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                    Singleton.getLoginInstance().getViewFactory().showErrorWindow();
                }
            });
        }

    }

    private void onReservation() throws Exception {
        BookControllerApp controllerApp = new BookControllerApp();
        ReservationBean reservationBean = controllerApp.getThisReservation(trainer,date,hour);
        if(controllerApp.savePrenotation(reservationBean)) {
            Singleton.getLoginInstance().addReservation(reservationBean);
            updateListView();
        }
    }

    private void updateListView() {
        listBook.setItems(Singleton.getLoginInstance().getLatestReservation());
        listBook.setCellFactory(e->new AthleteReservationCellFactory());
    }

    private void initAllReservationList() {
        if(Singleton.getLoginInstance().getLatestReservation().isEmpty()){
            Singleton.getLoginInstance().setLatestReservation();
        }
    }

    private void gatDate(ActionEvent event){
        LocalDate reservation= datePicker.getValue();
        this.date=reservation.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
    }
    private void getTrainer(ActionEvent event){
        this.trainer= trainerChoice.getValue();
    }
    private void getHour(ActionEvent event){
        this.hour= hourChoice.getValue();
    }
}
