package org.example.progetto.dao;

import org.example.progetto.exception.MyException;
import org.example.progetto.model.User;
import org.example.progetto.Singleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDao {
    public boolean checkIfExistATH(User user) {
        Statement statement;
        ResultSet rs;
        try{
            String tableName="Athlete_user";
            String query=String.format("select * from %s where Username= '%s'",tableName,user.getUsername());
            statement = retStatement();
            if (statement==null){
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
            catchE(e);
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
            statement = retStatement();
            if (statement==null){
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
            catchE(e);
            return false;
        }
        return false;
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
