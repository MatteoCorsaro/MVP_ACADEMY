package org.example.mvp_academy.other;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.mvp_academy.Bean.ReservationBean;
import org.example.mvp_academy.Bean.UserBean;
import org.example.mvp_academy.Dao.ConnectionDB;
import org.example.mvp_academy.View.ViewFactory;

import java.sql.ResultSet;

public class Singleton {
    private static Singleton singleton;
    private final ViewFactory viewFactory;
    private final ConnectionDB daoFactory;

    private ObservableList<ReservationBean> latestReservation;
    private final ObservableList<ReservationBean> allReservation;

    private UserBean user;
    private String error_message;

    public Singleton() {
        this.viewFactory = new ViewFactory();
        this.daoFactory = new ConnectionDB();

        this.allReservation = FXCollections.observableArrayList();
        this.latestReservation = FXCollections.observableArrayList();
    }

    public static synchronized Singleton getLoginInstance() {
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

    public ViewFactory getViewFactory(){
        return  viewFactory;
    }
    public ConnectionDB getDaoFactory() {
        return daoFactory;
    }
    public UserBean getUser(){return user;}
    public void setUser(UserBean user) {
        this.user = user;
    }

    public void setLatestReservation() {
        ResultSet rs=daoFactory.getReservation(this.user.getUsername());
        try {
            while (rs.next()){
                String trainer = rs.getString("trainer");
                String date= rs.getString("data");
                String hour = rs.getString("hour");
                this.latestReservation.add(new ReservationBean(date, trainer, hour));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ObservableList<ReservationBean> getLatestReservation() {
        return latestReservation;
    }

    public void addReservation(ReservationBean reservationBean) {
        this.latestReservation.add(reservationBean);
    }
    public void removeReservation(ReservationBean reservationBean) {
        this.latestReservation.remove(reservationBean);
    }

    public ObservableList getAllReservation() {
        return allReservation;
    }

    public void setAllReservation() {
        ResultSet rs=daoFactory.getAllReservation(this.user.getUsername());
        try {
            while (rs.next()){
                String athlete = rs.getString("name");
                String date= rs.getString("data");
                String hour = rs.getString("hour");
                this.allReservation.add(new ReservationBean(date, athlete, hour,null));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void removeReservation2(ReservationBean reservationBean) {
        this.allReservation.remove(reservationBean);
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }
}