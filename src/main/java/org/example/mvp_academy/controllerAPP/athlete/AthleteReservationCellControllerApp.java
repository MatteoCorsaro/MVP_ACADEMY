package org.example.mvp_academy.controllerAPP.athlete;

import org.example.mvp_academy.bean.ReservationBean;
import org.example.mvp_academy.dao.ReservationDao;
import org.example.mvp_academy.model.Reservation;
import org.example.mvp_academy.Singleton;

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

    public String retStateReservation(ReservationBean reservation) throws Exception {
        return reservation.getState();
    }
}
