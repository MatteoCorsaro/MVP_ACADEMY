package org.example.progetto.dao;

import org.example.progetto.model.User;
import org.example.progetto.Singleton;

import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDao {
    public boolean checkIfExistATH(User user) {
        Statement statement;
        ResultSet rs;
        try{
            String tableName="Athlete_user";
            String query=String.format("select * from %s where Username= '%s'",tableName,user.getUsername());
            try {
                statement = Singleton.getLoginInstance().getDaoFactory().getConnection().createStatement();
            }catch (Exception e){
                Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
                return false;
            }
            rs=statement.executeQuery(query);
            while(rs.next()){
                if((user.getPassword().equals(rs.getString("Password")))){
                    statement.close();
                    return true;
                }
            }
            statement.close();
        }catch (Exception e){
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            return false;
        }
        return false;
    }
/** CREARE Trainer_user DB**/
    public boolean checkIfExistTRN(User user) {
        Statement statement;
        ResultSet rs;
        try{
            String tableName="Trainer_user";
            String query=String.format("select * from %s where Username= '%s'",tableName,user.getUsername());
            try {
                statement = Singleton.getLoginInstance().getDaoFactory().getConnection().createStatement();
            }catch (Exception e){
                Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
                return false;
            }
            rs=statement.executeQuery(query);
            while(rs.next()){
                if((user.getPassword().equals(rs.getString("Password")))){
                    statement.close();
                    return true;
                }
            }
            statement.close();
        }catch (Exception e){
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            return false;
        }
        return false;
    }
}