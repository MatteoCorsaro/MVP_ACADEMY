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
import java.util.List;

public class ReservationDao {

    public void to_db(Reservation reservation) throws Exception{
        Statement statement;
        try{
            String date = reservation.getReservation_date().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
            String query=String.format("insert into %s(name,trainer,data,hour,state) values('%s','%s','%s','%s','%s');","reservation_table",reservation.getAthlete(),reservation.getTrainer(),date,reservation.getHour().toString(),reservation.getState());
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row correctly Inserted");
        }catch (SQLException e){
            Singleton.getLoginInstance().setError_message(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }
    }

    public Reservation from_db(String name){
        Statement statement;
        ResultSet rs;
        Reservation reservation = new Reservation();
        try{
            String query=String.format("select * from %s where name= '%s'","reservation_table",name);
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                reservation.setAthlete(rs.getString("name"));
                reservation.setTrainer(rs.getString("trainer"));

                LocalDate date=LocalDate.parse(rs.getString("data"), DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
                reservation.setReservation_date(date);

                HOUR Hour=HOUR.fromString(rs.getString("hour"));
                reservation.setHour(Hour);
                reservation.setState(rs.getString("state"));

                System.out.println(rs.getString("state"));
            }
            return reservation;
        }catch (SQLException e){
            Singleton.getLoginInstance().setError_message(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            return null;
        }
    }
    public void remove(Reservation reservation){
        Statement statement;
        try{
            String date=reservation.getReservation_date().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
            String query=String.format("delete from %s where name= '%s' and data= '%s' and hour= '%s'","reservation_table",reservation.getAthlete(),date,reservation.getHour().toString());
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        }catch (SQLException e){
            Singleton.getLoginInstance().setError_message(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }
    }

    public List<String> getAllPastDate(String username){
        Statement statement;
        ResultSet rs;
        Reservation reservation = new Reservation();
        try {
            String query = String.format("select * from %s where name= '%s'", "reservation_table", username);
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            List<String> allDate = new ArrayList<>();
            while (rs.next()) {
                if(rs.getString("state").equals(RESERVATION_STATE.PASSATA.toString()))
                    allDate.add(rs.getString("data"));
            }
            return allDate;
        }catch (SQLException e){
            Singleton.getLoginInstance().setError_message(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            return null;
        }
    }

    public void update(Reservation reservation,String newName){
        Statement statement;
        try{
            String query=String.format("update %s set state='%s' where state ='%s' and data='%s'","reservation_table",newName,"NON ACCETTATA",reservation.getReservation_date().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("CORRECTLY UPDATED");
        }catch (SQLException e){
            Singleton.getLoginInstance().setError_message(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }
    }

    public String getState(String format){
        Statement statement;
        ResultSet rs;
        Reservation reservation = new Reservation();
        try {
            String query = String.format("select * from %s where data= '%s'", "reservation_table", format);
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                return rs.getString("state");
            }
        }catch (SQLException e) {
            Singleton.getLoginInstance().setError_message(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }
        return RESERVATION_STATE.NON_ACCETTATA.toString();
    }

    public boolean checkReservation(String date, String hour){
        Statement statement;
        ResultSet rs;
        Reservation reservation = new Reservation();
        try {
            String query = String.format("select * from %s where data= '%s' and hour='%s'", "reservation_table", date,hour);
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()) {
                if(rs.getString("data").equals(date))
                    return false;
            }
            return true;
        }catch (SQLException e) {
            Singleton.getLoginInstance().setError_message(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            return true;
        }
    }
}
