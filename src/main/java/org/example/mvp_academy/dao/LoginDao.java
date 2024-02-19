package org.example.mvp_academy.dao;

import org.example.mvp_academy.model.User;
import org.example.mvp_academy.Singleton;

import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDao {
    public boolean checkIfExist_ATH(User user) {
        Statement statement;
        ResultSet rs;
        try{
            String table_name="Athlete_user";
            String query=String.format("select * from %s where Username= '%s'",table_name,user.getUsername());
            statement= Singleton.getLoginInstance().getDaoFactory().getConnection().createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                if((user.getPassword().equals(rs.getString("Password")))){
                    return true;
                }
            }
        }catch (Exception e){
            Singleton.getLoginInstance().setError_message(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            return false;
        }
        return false;
    }
/** CREARE Trainer_user DB**/
    public boolean checkIfExist_TRN(User user) {
        Statement statement;
        ResultSet rs;
        try{
            String table_name="Trainer_user";
            String query=String.format("select * from %s where Username= '%s'",table_name,user.getUsername());
            statement= Singleton.getLoginInstance().getDaoFactory().getConnection().createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                if((user.getPassword().equals(rs.getString("Password")))){
                    return true;
                }
            }
        }catch (Exception e){
            Singleton.getLoginInstance().setError_message(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            return false;
        }
        return false;
    }
}
