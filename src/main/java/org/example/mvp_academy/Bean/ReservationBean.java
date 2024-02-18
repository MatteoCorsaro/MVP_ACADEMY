package org.example.mvp_academy.Bean;

import org.example.mvp_academy.Model.Reservation;
import org.example.mvp_academy.other.Singleton;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ReservationBean {


    private Reservation reservation;

    public ReservationBean(String date, String trainer, String hour) {
        this.reservation=new Reservation(Singleton.getLoginInstance().getUser().getUsername(), trainer, date, hour);
        if(IsActive(date)==-1){
            this.reservation.setState("PASSATA");
        }
    }

    public ReservationBean(String date, String athlete, String hour, Object o) {
        this.reservation=new Reservation(athlete,Singleton.getLoginInstance().getUser().getUsername(), date, hour);
        if(IsActive(date)==-1){
            this.reservation.setState("PASSATA");
        }
    }

    public int IsActive(String givenDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        LocalDate date = LocalDate.parse(givenDate, formatter);
        LocalDate currentDate = LocalDate.now();

        long daysBetween = ChronoUnit.DAYS.between(currentDate, date);

        if (daysBetween < 0) {
            //System.out.println("The given date has passed.");
            this.reservation.setState("PASSATA");
            return(-1);
        } else if (daysBetween > 0) {
            //System.out.println("The given date has not arrived yet.");
            /*------CHECCA NEL DB SE ESISTONO ALTRE PRENOTAZIONI SIMILI------*/
            return(1);
        } else {
            //System.out.println("The given date is today.");
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
    /** vedere meglio questo metodo --------------------------------------------------------------------------------------------------**/
    public String getAthlete(){
        return reservation.getAthlete();
    }

    public Reservation getReservation() {
        return reservation;
    }

    public String getState() throws Exception {
        if(IsActive(getDate())==-1){
            this.reservation.setState("PASSATA");
        }
        return reservation.getState();
    }

}
