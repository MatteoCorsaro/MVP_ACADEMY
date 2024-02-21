package org.example.progetto.controller.athlete;

import org.example.progetto.bean.ReservationBean;
import org.example.progetto.dao.ReservationDao;
import org.example.progetto.model.Reservation;
import org.example.progetto.Singleton;

public class AthleteReservationCellControllerApp {

    public String retDateReservation(ReservationBean reservation) {
        return reservation.getDate();
    }


    public String retHourReservation(ReservationBean reservation) {
        return reservation.getHour();
    }

    public String retTrainerNameReservation(ReservationBean reservation) {
        return reservation.getTrainer();
    }

    public void remove(ReservationBean reservationbean){
        ReservationDao reservationDao = new ReservationDao();
        Reservation reservation= reservationbean.getReservation();
        reservationDao.remove(reservation);
        Singleton.getLoginInstance().removeReservation(reservationbean);
    }

    public String retStateReservation(ReservationBean reservation){
        return reservation.getState();
    }
}
