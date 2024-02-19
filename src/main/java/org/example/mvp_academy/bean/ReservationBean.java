package org.example.mvp_academy.bean;

import org.example.mvp_academy.model.Reservation;
import org.example.mvp_academy.RESERVATION_STATE;
import org.example.mvp_academy.Singleton;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ReservationBean {


    private final Reservation reservation;

    public ReservationBean(String date, String trainer, String hour) {
        this.reservation=new Reservation(Singleton.getLoginInstance().getUser().getUsername(), trainer, date, hour);
        if(isActive(date)==-1){
            this.reservation.setState(RESERVATION_STATE.PASSATA.toString());
        }
    }

    public int isActive(String givenDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        LocalDate date = LocalDate.parse(givenDate, formatter);
        LocalDate currentDate = LocalDate.now();

        long daysBetween = ChronoUnit.DAYS.between(currentDate, date);

        if (daysBetween < 0) {
            this.reservation.setState(RESERVATION_STATE.PASSATA.toString());
            return(-1);
        } else if (daysBetween > 0) {
            return(1);
        } else {
            return(0);
        }
    }
    public String getDate(){
        LocalDate date = reservation.getReservation_date();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        return date.format(formatter);
    }
    public String getHour(){
        return reservation.getHour().toString();
    }
    public String getTrainer(){
        return reservation.getTrainer();
    }

    public String getAthlete(){
        return reservation.getAthlete();
    }

    public Reservation getReservation() {
        return reservation;
    }

    public String getState() throws Exception {
        if(isActive(getDate())==-1){
            this.reservation.setState(RESERVATION_STATE.PASSATA.toString());
        }
        return reservation.getState();
    }

}
