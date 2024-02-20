package org.example.mvp_academy.dao;

import org.example.mvp_academy.model.User;
import org.example.mvp_academy.Singleton;

import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDao {
    public boolean checkIfExistATH(User user) {
        Statement statement;
        ResultSet rs;
        try{
            String tableName="Athlete_user";
            String query=String.format("select * from %s where Username= '%s'",tableName,user.getUsername());
            statement= Singleton.getLoginInstance().getDaoFactory().getConnection().createStatement();
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
            statement= Singleton.getLoginInstance().getDaoFactory().getConnection().createStatement();
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
