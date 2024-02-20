package org.example.mvp_academy.controllerAPP.trainer;

import org.example.mvp_academy.RESERVATION_STATE;
import org.example.mvp_academy.bean.ReservationBean;
import org.example.mvp_academy.dao.ReservationDao;
import org.example.mvp_academy.model.Reservation;
import org.example.mvp_academy.Singleton;

public class TrainerReservationCellControllerApp {
    public String retDateReservation(ReservationBean reservation) {
        return reservation.getDate();
    }

    public String retHourReservation(ReservationBean reservation) {
        return reservation.getHour();
    }

    public void accept(ReservationBean reservationBean){
        ReservationDao reservationDao = new ReservationDao();
        Reservation reservation= reservationBean.getReservation();
        reservationDao.update(reservation, RESERVATION_STATE.ACCETTATA.toString());
    }

    public void remove(ReservationBean reservationBean){
        ReservationDao reservationDao = new ReservationDao();
        Reservation reservation= reservationBean.getReservation();
        reservationDao.remove(reservation);
        Singleton.getLoginInstance().removeReservation2(reservationBean);
    }

    public String retNameReservation(ReservationBean reservation) {
        return reservation.getAthlete2();
    }

}
