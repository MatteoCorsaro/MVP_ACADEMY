package org.example.mvp_academy.controllerUI.Athlete;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import org.example.mvp_academy.bean.ReservationBean;
import org.example.mvp_academy.view.A_reservationCellFactory;
import org.example.mvp_academy.controllerAPP.Athlete.BookControllerApp;
import org.example.mvp_academy.HOUR;
import org.example.mvp_academy.Singleton;
import org.example.mvp_academy.TRAINER_LIST;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class BookControllerUI implements Initializable {
    public DatePicker Date_picker;
    public ChoiceBox<String> Hour_choice;
    public Button confirm_btn;
    public ChoiceBox<String> Trainer_choice;
    public ListView<ReservationBean> listBook;

    public String trainer;
    public String hour;
    public String date;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAllReservationList();
        updateListView();
        String user= Singleton.getLoginInstance().getUser().getUsername();

        Date_picker.setOnAction(this::gatDate);

        String[] trainers={TRAINER_LIST.EMANUELE.toString(),TRAINER_LIST.MATTIA.toString(),TRAINER_LIST.MASSIMILIANO.toString()};
        Trainer_choice.getItems().addAll(trainers);
        Trainer_choice.setOnAction(this::getTrainer);

        String[] hours={HOUR.prima.toString(),HOUR.seconda.toString(),HOUR.terza.toString(),HOUR.quarta.toString()};
        Hour_choice.getItems().addAll(hours);
        Hour_choice.setOnAction(this::getHour);

        if(Date_picker!=null || trainer!=null || hour!=null){
            confirm_btn.setOnAction(event -> {
                try {
                    onReservation();
                } catch (Exception e) {
                    Singleton.getLoginInstance().setError_message(e.getMessage());
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
        listBook.setCellFactory(e->new A_reservationCellFactory());
    }

    private void initAllReservationList() {
        if(Singleton.getLoginInstance().getLatestReservation().isEmpty()){
            Singleton.getLoginInstance().setLatestReservation();
        }
    }

    private void gatDate(ActionEvent event){
        LocalDate reservation=Date_picker.getValue();
        this.date=reservation.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
    }
    private void getTrainer(ActionEvent event){
        this.trainer=Trainer_choice.getValue();
    }
    private void getHour(ActionEvent event){
        this.hour=Hour_choice.getValue();
    }
}
