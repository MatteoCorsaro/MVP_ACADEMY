package org.example.mvp_academy.controllerAPP.athlete;

import org.example.mvp_academy.Singleton;
import org.example.mvp_academy.bean.ReservationBean;
import org.example.mvp_academy.dao.ReservationDao;
import org.example.mvp_academy.model.Reservation;

public class BookControllerApp {

    public ReservationBean getThisReservation(String trainer, String date, String hour) {
        return new ReservationBean(date,trainer,hour);
    }

    public boolean savePrenotation(ReservationBean reservationBean){
        Reservation reservation = reservationBean.getReservation();
        ReservationDao reservationDao = new ReservationDao();
        if(reservationBean.isActive(reservationBean.getDate())==-1){
            Singleton.getLoginInstance().setErrorMessage("YOU CANNOT BOOK ON A PAST DAY");
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            return false;
        }
        if(reservationDao.checkReservation(reservationBean.getDate(),reservationBean.getHour())) {
            reservationDao.toDb(reservation);
            return true;
        }
        Singleton.getLoginInstance().setErrorMessage("SOMEONE HAS ALREADY BOOKED ON THIS DAY AND AT THIS TIME");
        Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        return false;
    }
}
