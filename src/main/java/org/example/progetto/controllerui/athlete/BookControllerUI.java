package org.example.progetto.controllerui.athlete;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import org.example.progetto.SingletonSecondView;
import org.example.progetto.bean.ReservationBean;
import org.example.progetto.exception.MyException;
import org.example.progetto.view.AthleteReservationCellFactory;
import org.example.progetto.controller.athlete.BookControllerApp;
import org.example.progetto.HOUR;
import org.example.progetto.Singleton;
import org.example.progetto.TRAINER_LIST;

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
                    Singleton.getLoginInstance().getMyException().exceptionDB(e);
                }
            });
        }

    }

    private void onReservation(){
        BookControllerApp controllerApp = new BookControllerApp();
        ReservationBean reservationBean = controllerApp.getThisReservation(trainer,date,hour, Singleton.getLoginInstance().getUser().getUsername());
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
