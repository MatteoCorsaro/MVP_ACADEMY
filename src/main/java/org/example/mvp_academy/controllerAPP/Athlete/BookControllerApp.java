package org.example.mvp_academy.controllerAPP.Athlete;

import org.example.mvp_academy.Bean.ReservationBean;
import org.example.mvp_academy.Dao.ReservationDao;
import org.example.mvp_academy.Model.Reservation;
import org.example.mvp_academy.exceptions.ReservationException;

public class BookControllerApp {

    public ReservationBean getThisReservation(String trainer, String date, String hour) {
        return new ReservationBean(date,trainer,hour);
    }

    public boolean savePrenotation(ReservationBean reservationBean) throws Exception {
        Reservation reservation = reservationBean.getReservation();
        ReservationDao reservationDao = new ReservationDao();
        if(reservationBean.IsActive(reservationBean.getDate())==-1){
            //ReservationException.outOfRange();
            return false;
        }
        if(reservationDao.checkReservation(reservationBean.getDate(),reservationBean.getHour())) {
            reservationDao.to_db(reservation);
            return true;
        }
        //ReservationException.alreadyExisting();
        return false;
    }
}
