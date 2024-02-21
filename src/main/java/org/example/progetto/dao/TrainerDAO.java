package org.example.progetto.dao;

import org.example.progetto.Singleton;
import org.example.progetto.exception.MyException;
import org.example.progetto.model.Trainer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TrainerDAO {
    public Trainer getAthleteByUsername(String username) {

        Trainer trainer=new Trainer();
        Statement statement = null;
        ResultSet rs;
        try{
            String trainerTable="Trainer_table";
            String query=String.format("select * from %s where Username= '%s'",trainerTable,username);

            statement = retStatement();
            if (statement==null){
                return null;
            }
            rs=statement.executeQuery(query);

            while(rs.next()) {
                trainer.setName(rs.getString("Name"));
                trainer.setSurname(rs.getString("Surname"));
            }
            statement.close();
            return trainer;
        }catch (Exception e){
            catchE(e);
            return null;
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
