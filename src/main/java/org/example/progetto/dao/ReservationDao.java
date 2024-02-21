package org.example.progetto.dao;

import org.example.progetto.exception.MyException;
import org.example.progetto.model.Reservation;
import org.example.progetto.HOUR;
import org.example.progetto.RESERVATION_STATE;
import org.example.progetto.Singleton;

import java.sql.*;
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
            statement = retStatement();
            if (statement==null){
                return;
            }
            statement.executeUpdate(query);
            statement.close();
        }catch (SQLException e){
            catchE(e);
        }
    }

    public Reservation fromDb(String name){
        Statement statement;
        ResultSet rs;
        Reservation reservation = new Reservation();
        try{
            String query=String.format("select * from %s where name= '%s'",TABLE,name);
            statement = retStatement();
            if (statement==null){
                return null;
            }
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
            catchE(e);
            return null;
        }
    }
    public void remove(Reservation reservation){
        Statement statement;
        try{
            String date=reservation.getReservationDate().format(DateTimeFormatter.ofPattern(FORMATT));
            String query=String.format("delete from %s where name= '%s' and data= '%s' and hour= '%s'",TABLE,reservation.getAthlete(),date,reservation.getHour().toString());
            statement = retStatement();
            if (statement==null){
                return;
            }
            statement.executeUpdate(query);
            statement.close();
        }catch (SQLException e){
            catchE(e);
        }
    }

    public List<String> getAllPastDate(String username){
        Statement statement;
        ResultSet rs;
        try {
            String query = String.format("select * from %s where name= '%s'", TABLE, username);
            statement = retStatement();
            if (statement==null){
                return Collections.emptyList();
            }
            rs = statement.executeQuery(query);
            List<String> allDate = new ArrayList<>();
            while (rs.next()) {
                if(rs.getString(STATE).equals(RESERVATION_STATE.PASSATA.toString()))
                    allDate.add(rs.getString("data"));
            }
            statement.close();
            return allDate;
        }catch (SQLException e){
            catchE(e);
            return Collections.emptyList();
        }
    }

    public void update(Reservation reservation,String newName){
        Statement statement;
        try{
            String query=String.format("update %s set state='%s' where state ='%s' and data='%s' and hour='%s'",TABLE,newName,"NON ACCETTATA",reservation.getReservationDate().format(DateTimeFormatter.ofPattern(FORMATT)), reservation.getHour().toString());
            statement = retStatement();
            if (statement==null){
                return;
            }
            statement.executeUpdate(query);
            statement.close();
        }catch (SQLException e){
            catchE(e);
        }
    }

    public String getState(String format){
        Statement statement;
        ResultSet rs;
        try {
            String query = String.format("select * from %s where data= '%s'", TABLE, format);
            statement = retStatement();
            if (statement==null){
                return RESERVATION_STATE.NON_ACCETTATA.toString();
            }
            rs = statement.executeQuery(query);
            String state = null;
            while (rs.next()) {
                state=rs.getString(STATE);
            }
            statement.close();
            return state;
        }catch (SQLException e) {
            catchE(e);
        }
        return RESERVATION_STATE.NON_ACCETTATA.toString();
    }

    public boolean checkReservation(String date, String hour){
        Statement statement;
        ResultSet rs;
        try {
            String query = String.format("select * from %s where data= '%s' and hour='%s'", TABLE, date,hour);
            statement = retStatement();
            if (statement==null){
                return true;
            }
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
            catchE(e);
            return true;
        }
    }
    public String getName(String format){
        Statement statement;
        ResultSet rs;
        try {
            String query = String.format("select * from %s where data= '%s'", TABLE, format);
            statement = retStatement();
            if (statement==null){
                return "";
            }
            rs = statement.executeQuery(query);
            String name = null;
            while (rs.next()) {
                name=rs.getString("name");
            }
            statement.close();
            return name;
        }catch (SQLException e) {
            catchE(e);
            return "";
        }
    }
    public static Statement retStatement() {
        Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
        try {
            return conn.createStatement();
        } catch (Exception e) {
            catchE(e);
            return null;
        }
    }
    private static void catchE(Exception e){
        MyException.getInstance().exceptionDB(e);
    }
}
