package org.example.mvp_academy.dao;

import org.example.mvp_academy.model.Reservation;
import org.example.mvp_academy.HOUR;
import org.example.mvp_academy.RESERVATION_STATE;
import org.example.mvp_academy.Singleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReservationDao {

    private static final String FORMATT = "dd-MMM-yyyy";
    private static final String TABLE = "reservation_table";
    private static final String STATE = "state";

    public void toDb(Reservation reservation){
        Statement statement;
        try{
            String date = reservation.getReservationDate().format(DateTimeFormatter.ofPattern(FORMATT));
            String query=String.format("insert into %s(name,trainer,data,hour,state) values('%s','%s','%s','%s','%s');",TABLE,reservation.getAthlete(),reservation.getTrainer(),date,reservation.getHour().toString(),reservation.getState());
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement=conn.createStatement();
            statement.executeUpdate(query);
            statement.close();
        }catch (SQLException e){
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }
    }

    public Reservation fromDb(String name){
        Statement statement;
        ResultSet rs;
        Reservation reservation = new Reservation();
        try{
            String query=String.format("select * from %s where name= '%s'",TABLE,name);
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                reservation.setAthlete(rs.getString("name"));
                reservation.setTrainer(rs.getString("trainer"));

                LocalDate date=LocalDate.parse(rs.getString("data"), DateTimeFormatter.ofPattern(FORMATT));
                reservation.setReservationDate(date);

                HOUR hour=HOUR.fromString(rs.getString("hour"));
                reservation.setHour(hour);
                reservation.setState(rs.getString(STATE));

            }
            statement.close();
            return reservation;
        }catch (SQLException e){
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            return null;
        }
    }
    public void remove(Reservation reservation){
        Statement statement;
        try{
            String date=reservation.getReservationDate().format(DateTimeFormatter.ofPattern(FORMATT));
            String query=String.format("delete from %s where name= '%s' and data= '%s' and hour= '%s'",TABLE,reservation.getAthlete(),date,reservation.getHour().toString());
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement=conn.createStatement();
            statement.executeUpdate(query);
            statement.close();
        }catch (SQLException e){
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }
    }

    public List<String> getAllPastDate(String username){
        Statement statement;
        ResultSet rs;
        try {
            String query = String.format("select * from %s where name= '%s'", TABLE, username);
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            List<String> allDate = new ArrayList<>();
            while (rs.next()) {
                if(rs.getString(STATE).equals(RESERVATION_STATE.PASSATA.toString()))
                    allDate.add(rs.getString("data"));
            }
            statement.close();
            return allDate;
        }catch (SQLException e){
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            return Collections.emptyList();
        }
    }

    public void update(Reservation reservation,String newName){
        Statement statement;
        try{
            String query=String.format("update %s set state='%s' where state ='%s' and data='%s' and hour='%s'",TABLE,newName,RESERVATION_STATE.NON_ACCETTATA.toString(),reservation.getReservationDate().format(DateTimeFormatter.ofPattern(FORMATT)), reservation.getHour().toString());
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement=conn.createStatement();
            statement.executeUpdate(query);
            statement.close();
        }catch (SQLException e){
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }
    }

    public String getState(String format){
        Statement statement;
        ResultSet rs;
        try {
            String query = String.format("select * from %s where data= '%s'", TABLE, format);
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            String state = null;
            while (rs.next()) {
                state=rs.getString(STATE);
            }
            statement.close();
            return state;
        }catch (SQLException e) {
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }
        return RESERVATION_STATE.NON_ACCETTATA.toString();
    }

    public boolean checkReservation(String date, String hour){
        Statement statement;
        ResultSet rs;
        try {
            String query = String.format("select * from %s where data= '%s' and hour='%s'", TABLE, date,hour);
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()) {
                if(rs.getString("data").equals(date)){
                    statement.close();
                    return false;
                }
            }
            statement.close();
            return true;
        }catch (SQLException e) {
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            return true;
        }
    }
    public String getName(String format){
        Statement statement = null;
        ResultSet rs;
        try {
            String query = String.format("select * from %s where data= '%s'", TABLE, format);
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            String name = null;
            while (rs.next()) {
                name=rs.getString("name");
            }
            statement.close();
            return name;
        }catch (SQLException e) {
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            return "";
        }
    }
}
