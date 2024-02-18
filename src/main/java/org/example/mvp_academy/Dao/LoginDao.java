package org.example.mvp_academy.Dao;

import org.example.mvp_academy.Model.User;
import org.example.mvp_academy.other.Singleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDao {
    public boolean checkIfExist_ATH(User user) {
        Statement statement;
        ResultSet rs = null;
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
            System.out.println(e);
            return false;
        }
        return false;
    }
/** CREARE Trainer_user DB**/
    public boolean checkIfExist_TRN(User user) {
        Statement statement;
        ResultSet rs = null;
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
            System.out.println(e);
            return false;
        }
        return false;
    }
}
