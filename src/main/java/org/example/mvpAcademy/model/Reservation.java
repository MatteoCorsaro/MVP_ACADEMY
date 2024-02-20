package org.example.mvpAcademy.model;

import org.example.mvpAcademy.RESERVATION_STATE;
import org.example.mvpAcademy.dao.ReservationDao;
import org.example.mvpAcademy.HOUR;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

    private String username;
    private String trainer;
    private LocalDate reservationDate;
    private HOUR hour;
    private String state;

    public Reservation(){
        this.username=null;
        this.trainer=null;
        this.reservationDate =null;
        this.hour=null;
        this.state=null;
    }

    public Reservation(String athlete, String trainer, String date, String hour){
        this.username=athlete;
        this.trainer=trainer;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        this.reservationDate =LocalDate.parse(date, formatter);
        this.hour=HOUR.fromString(hour);
        this.state= RESERVATION_STATE.NON_ACCETTATA.toString();
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
    public LocalDate getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }
    public HOUR getHour() {
        return hour;
    }
    public void setHour(HOUR hour) {
        this.hour = hour;
    }

    public String getState(){
        ReservationDao reservationDao= new ReservationDao();
        this.state =  reservationDao.getState(this.reservationDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
        if(state==null){
            setState(RESERVATION_STATE.NON_ACCETTATA.toString());
        }
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getAthlete2() {
        ReservationDao reservationDao= new ReservationDao();
        return reservationDao.getName(this.reservationDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
    }

}
