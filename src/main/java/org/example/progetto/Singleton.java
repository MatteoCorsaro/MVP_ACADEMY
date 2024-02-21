package org.example.progetto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.progetto.bean.ReservationBean;
import org.example.progetto.bean.UserBean;
import org.example.progetto.dao.ConnectionDB;
import org.example.progetto.exception.MyException;
import org.example.progetto.view.ViewFactory;
import java.sql.ResultSet;

public class Singleton {

    private static Singleton singleton;
    private final ViewFactory viewFactory;

    private final ConnectionDB daoFactory;
    private final MyException myException;

    private final ObservableList<ReservationBean> latestReservation;
    private final ObservableList<ReservationBean> allReservation;

    private UserBean user;
    private String errorMessage;

    public Singleton() {
        this.viewFactory = new ViewFactory();
        this.daoFactory = new ConnectionDB();this.myException=new MyException();
        this.myException.setUserInterface("GUI");

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
    public MyException getMyException(){
        return myException;
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
                this.latestReservation.add(new ReservationBean(date, trainer, hour,Singleton.getLoginInstance().getUser().getUsername()));
            }
        }catch (Exception e){
            MyException ex = new MyException();
            ex.exceptionDB(e);
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
                this.allReservation.add(new ReservationBean(date, athlete, hour,Singleton.getLoginInstance().getUser().getUsername()));
            }
        }catch (Exception e){
            MyException ex = new MyException();
            ex.exceptionDB(e);
        }
    }
    public void removeReservation2(ReservationBean reservationBean) {
        this.allReservation.remove(reservationBean);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}