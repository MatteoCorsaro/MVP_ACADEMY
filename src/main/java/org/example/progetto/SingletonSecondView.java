package org.example.progetto;


import org.example.progetto.bean.ReservationBean;
import org.example.progetto.bean.UserBean;
import org.example.progetto.dao.ConnectionDB;
import org.example.progetto.exception.MyException;
import org.example.progetto.secondview.SecondViewFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SingletonSecondView {

    private final PrintStream printerStream;
    private final BufferedReader readerStream;

    private static SingletonSecondView singleton;
    private final SecondViewFactory viewFactory;

    private final ConnectionDB daoFactory;
    private final MyException myException;

    private UserBean user;
    private String errorMessage;

    private final ArrayList<ReservationBean> latestReservation;
    private final ArrayList<ReservationBean> allReservation;

    public SingletonSecondView() {
        this.viewFactory = new SecondViewFactory();
        this.daoFactory = new ConnectionDB();
        this.myException=new MyException();
        this.myException.setUserInterface("CLI");

        this.printerStream=new PrintStream(System.out);
        this.readerStream=new BufferedReader(new InputStreamReader(System.in));

        this.allReservation = new ArrayList<>();
        this.latestReservation = new ArrayList<>();
    }

    public static synchronized SingletonSecondView getLoginInstance() {
        if (singleton == null){
            singleton = new SingletonSecondView();
        }
        return singleton;
    }

    public SecondViewFactory getViewFactory(){
        return  viewFactory;
    }
    public ConnectionDB getDaoFactory() {
        return daoFactory;
    }
    public MyException getMyException(){
        return myException;
    }
    public BufferedReader getReaderStream() {
        return readerStream;
    }
    public PrintStream getPrinterStream() {
        return printerStream;
    }

    public UserBean getUser(){return user;}

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /*----GESTIRE LE RESERVATION-----------*/
    public void setLatestReservation() {
        ResultSet rs=daoFactory.getReservation(this.user.getUsername());
        try {
            while (rs.next()){
                String trainer = rs.getString("trainer");
                String date= rs.getString("data");
                String hour = rs.getString("hour");
                this.latestReservation.add(new ReservationBean(date, trainer, hour,SingletonSecondView.getLoginInstance().getUser().getUsername()));
            }
        }catch (Exception e){
            MyException ex = new MyException();
            ex.exceptionDB(e);
        }
    }

    public List<ReservationBean> getLatestReservation() {
        return latestReservation;
    }

    public void addReservation(ReservationBean reservationBean) {
        this.latestReservation.add(reservationBean);
    }
    public void removeReservation(ReservationBean reservationBean) {
        this.latestReservation.remove(reservationBean);
    }

    public List<ReservationBean> getAllReservation() {
        return allReservation;
    }

    public void setAllReservation() {
        ResultSet rs=daoFactory.getAllReservation(this.user.getUsername());
        try {
            while (rs.next()){
                String athlete = rs.getString("name");
                String date= rs.getString("data");
                String hour = rs.getString("hour");
                this.allReservation.add(new ReservationBean(date, athlete, hour,SingletonSecondView.getLoginInstance().getUser().getUsername()));
            }
        }catch (Exception e){
            MyException ex = new MyException();
            ex.exceptionDB(e);
        }
    }
    public void removeReservation2(ReservationBean reservationBean) {
        this.allReservation.remove(reservationBean);
    }

}
