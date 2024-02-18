package org.example.mvp_academy.Dao;

import org.example.mvp_academy.Bean.AthleteBean;
import org.example.mvp_academy.Model.Athlete;
import org.example.mvp_academy.other.POSITION;
import org.example.mvp_academy.other.Singleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class AthleteDAO {

    public static Date stringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyy");
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static  Athlete getAthleteByUsername(String username) {
        Athlete athlete=new Athlete();
        Statement statement;
        ResultSet rs = null;
        try{
            String table_name="Athlete_table";
            String query=String.format("select * from %s where Username= '%s'",table_name,username);
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();
            statement= conn.createStatement();
            rs=statement.executeQuery(query);

            while(rs.next()) {
                athlete.setName(rs.getString("Name"));
                athlete.setSurname(rs.getString("Surname"));

                Date birth = stringToDate(rs.getString("Birth"));
                athlete.setDate_of_birth(birth);

                athlete.setTeam(rs.getString("Team"));

                POSITION pos = POSITION.fromString(rs.getString("Position"));
                athlete.setPosition(pos);

            }
            return athlete;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public static AthleteBean ret_Bean(String username)
    {
        Athlete athlete = getAthleteByUsername(username);
        if(athlete==null){
            return null;
        }
        return new AthleteBean(athlete.getName(), athlete.getSurname(), athlete.getDate_of_birth(), athlete.getTeam(), athlete.getPosition());
    }
}
