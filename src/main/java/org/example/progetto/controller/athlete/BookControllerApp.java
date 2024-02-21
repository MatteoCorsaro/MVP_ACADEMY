package org.example.progetto.controller.athlete;

import org.example.progetto.bean.ReservationBean;
import org.example.progetto.dao.ReservationDao;
import org.example.progetto.exception.MyException;
import org.example.progetto.model.Reservation;

public class BookControllerApp {

    public ReservationBean getThisReservation(String trainer, String date, String hour, String user) {
        ReservationBean bean = new ReservationBean(date,trainer,hour, user);

        System.out.println(bean.getHour());
        System.out.println(bean.getDate());
        System.out.println(bean.getTrainer());
        return bean;
    }

    public boolean savePrenotation(ReservationBean reservationBean){
        Reservation reservation = reservationBean.getReservation();
        ReservationDao reservationDao = new ReservationDao();
        if(reservationBean.isActive(reservationBean.getDate())==-1){
            MyException.getInstance().alreadyExist();
            return false;
        }
        if(reservationDao.checkReservation(reservationBean.getDate(),reservationBean.getHour())) {
            reservationDao.toDb(reservation);
            return true;
        }
        MyException.getInstance().alreadyExist();
        return false;
    }
}
