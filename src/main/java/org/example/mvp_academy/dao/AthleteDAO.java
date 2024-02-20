package org.example.mvp_academy.dao;

import org.example.mvp_academy.bean.AthleteBean;
import org.example.mvp_academy.model.Athlete;
import org.example.mvp_academy.POSITION;
import org.example.mvp_academy.Singleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AthleteDAO {

    private AthleteDAO(){
        throw new IllegalStateException("Utility class");
    }

    public static Date stringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyy");
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            return null;
        }
    }

    public static  Athlete getAthleteByUsername(String username) {
        Athlete athlete=new Athlete();
        Statement statement;
        ResultSet rs;
        try{
            String athleteTable="Athlete_table";
            String query=String.format("select * from %s where Username= '%s'",athleteTable,username);
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();

            statement= conn.createStatement();
            rs=statement.executeQuery(query);

            while(rs.next()) {
                athlete.setName(rs.getString("Name"));
                athlete.setSurname(rs.getString("Surname"));

                Date birth = stringToDate(rs.getString("Birth"));
                athlete.setDateOfBirth(birth);

                athlete.setTeam(rs.getString("Team"));

                POSITION pos = POSITION.fromString(rs.getString("Position"));
                athlete.setPosition(pos);

            }
            statement.close();
            return athlete;
        }catch (Exception e){
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            return null;
        }
    }
    public static AthleteBean retBean(String username)
    {
        Athlete athlete = getAthleteByUsername(username);
        if(athlete==null){
            return null;
        }
        return new AthleteBean(athlete.getName(), athlete.getSurname(), athlete.getDateOfBirth(), athlete.getTeam(), athlete.getPosition());
    }
}
