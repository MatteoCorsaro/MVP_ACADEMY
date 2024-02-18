package org.example.mvp_academy.Model;

import org.example.mvp_academy.Dao.ReservationDao;
import org.example.mvp_academy.other.HOUR;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

    private String username;
    private String trainer;
    private LocalDate reservation_date;
    private HOUR hour;
    private String state;

    public Reservation(){
        this.username=null;
        this.trainer=null;
        this.reservation_date=null;
        this.hour=null;
        this.state=null;
    }

    public Reservation(String athlete, String trainer, String date, String hour){
        this.username=athlete;
        this.trainer=trainer;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        this.reservation_date=LocalDate.parse(date, formatter);
        this.hour=HOUR.fromString(hour);
        this.state="NON ACCETTATA";
    }


    public String getAthlete() {
        return username;
    }
    public void setAthlete(String athlete) {
        this.username = athlete;
    }
    public String getTrainer() {
        return trainer;
    }
    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }
    public LocalDate getReservation_date() {
        return reservation_date;
    }
    public void setReservation_date(LocalDate reservation_date) {
        this.reservation_date = reservation_date;
    }
    public HOUR getHour() {
        return hour;
    }
    public void setHour(HOUR hour) {
        this.hour = hour;
    }

    public String getState() throws Exception {
        ReservationDao reservationDao= new ReservationDao();
        this.state =  reservationDao.getState(this.reservation_date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
        if(state==null){
            setState("NON ACCETTATA");
        }
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

}
