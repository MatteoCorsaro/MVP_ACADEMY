package org.example.mvp_academy.controllerAPP.Trainer;

import org.example.mvp_academy.bean.ReservationBean;
import org.example.mvp_academy.dao.ReservationDao;
import org.example.mvp_academy.model.Reservation;
import org.example.mvp_academy.Singleton;

public class T_ReservationCellControllerApp {
    public String ret_date_reservation(ReservationBean reservation) {
        return reservation.getDate();
    }

    public String ret_hour_reservation(ReservationBean reservation) {
        return reservation.getHour();
    }

    public void accept(ReservationBean reservationBean) throws Exception {
        ReservationDao reservationDao = new ReservationDao();
        Reservation reservation= reservationBean.getReservation();
        reservationDao.update(reservation,"ACCETTATA");
    }

    public void remove(ReservationBean reservationBean) throws Exception {
        ReservationDao reservationDao = new ReservationDao();
        Reservation reservation= reservationBean.getReservation();
        reservationDao.remove(reservation);
        Singleton.getLoginInstance().removeReservation2(reservationBean);
    }

    public String ret_Name_reservation(ReservationBean reservation) {
        return reservation.getAthlete();
    }

}
