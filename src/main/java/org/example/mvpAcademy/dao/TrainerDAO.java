package org.example.mvpAcademy.dao;

import org.example.mvpAcademy.Singleton;
import org.example.mvpAcademy.model.Trainer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TrainerDAO {
    public Trainer getAthleteByUsername(String username) {

        Trainer trainer=new Trainer();
        Statement statement;
        ResultSet rs;
        try{
            String trainerTable="Trainer_table";
            String query=String.format("select * from %s where Username= '%s'",trainerTable,username);
            Connection conn = Singleton.getLoginInstance().getDaoFactory().getConnection();

            statement= conn.createStatement();
            rs=statement.executeQuery(query);

            while(rs.next()) {
                trainer.setName(rs.getString("Name"));
                trainer.setSurname(rs.getString("Surname"));

            }
            statement.close();
            return trainer;
        }catch (Exception e){
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            return null;
        }
    }
}
