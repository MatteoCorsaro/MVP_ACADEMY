package org.example.progetto.dao;

import org.example.progetto.Singleton;
import org.example.progetto.exception.MyException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionDB {
    private Connection conn;

    public ConnectionDB(){
        try (InputStream input = new FileInputStream("C:\\Users\\Matteo\\OneDrive\\Desktop\\Progetto\\5 Code\\MVP_ACADEMY\\src\\main\\java\\org\\example\\progetto\\Dao\\config.proprties")) {
            Properties properties = new Properties();
            properties.load(input);

            String connectionUrl = properties.getProperty("DB_NAME");
            String user = properties.getProperty("USER");
            String pass = properties.getProperty("PASS");
            this.conn = connetc_to_db(connectionUrl, user, pass);
        } catch (IOException e) {
            this.conn=null;
            catchE(e);
        }
    }


    public Connection connetc_to_db(String dbname,String user, String password){
        Connection connection=null;
        try{
            Class.forName("org.postgresql.Driver");
            connection=DriverManager.getConnection(STR."jdbc:postgresql://localhost:5432/\{dbname}",user,password);
            if(connection!=null) {
                System.out.println("Connection Established");
            }else{
                System.out.println("Connection Failed");
            }
        }catch (Exception e){
            catchE(e);
        }
        return connection;
    }
    public void closeConnection() throws SQLException { this.conn.close(); }

    public Connection getConnection() {
        return conn;
    }

    public ResultSet getReservation(String username){
        Statement statement;
        ResultSet resultSet=null;
        try{
            statement = this.conn.createStatement();
            resultSet=statement.executeQuery(STR."select * from reservation_table where name= '\{username}';");
        }catch (Exception e){
            catchE(e);
        }
        return resultSet;
    }

    public ResultSet getAllReservation(String username){
        Statement statement;
        ResultSet resultSet=null;
        try{
            statement = this.conn.createStatement();
            resultSet=statement.executeQuery(STR."select * from reservation_table where trainer= '\{username}';");
        }catch (Exception e){
            catchE(e);
        }
        return resultSet;
    }
    private static void catchE(Exception e){
        MyException.getInstance().exceptionDB(e);
    }
}
