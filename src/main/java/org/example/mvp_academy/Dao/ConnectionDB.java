package org.example.mvp_academy.Dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionDB {
    private final Connection conn;

    public ConnectionDB() {
        try (InputStream input = new FileInputStream("C:\\Users\\Matteo\\OneDrive\\Desktop\\Progetto\\5 Code\\MVP_ACADEMY\\src\\main\\java\\org\\example\\mvp_academy\\Dao\\config.proprties")) {
            Properties properties = new Properties();
            properties.load(input);

            String connection_url = properties.getProperty("DB_NAME");
            String user = properties.getProperty("USER");
            String pass = properties.getProperty("PASS");
            this.conn = connetc_to_db(connection_url, user, pass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection connetc_to_db(String dbname,String user, String password){
        Connection conn=null;
        try{
            Class.forName("org.postgresql.Driver");
            conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,password);
            if(conn!=null) {
                System.out.println("Connection Established");
            }else{
                System.out.println("Connection Failed");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }
    public void closeConnection() throws SQLException { this.conn.close(); }

    public Connection getConnection() {
        return conn;
    }
    /*---------------------------------------------------------------------------------------------------------------------------*/
    /*** CREA TABELLA ***/
    public void create_table(Connection conn, String table_name){
        Statement statement;
        try{
            String query= "create table "+table_name+"(athid SERIAL, Username varchar(200), Name varchar(100), Surname varchar(200), Birth varchar(200), Team varchar(200), Position varchar(200),primary key(athid));";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    /*** INSERT DATA ***/
    public void insert_row(Connection conn,String table_name, String Username, String name,String Surname, String date, String Team, String pos){
        Statement statement;
        try{
            String query=String.format("insert into %s(Username,Name,Surname,Birth,Team,Position) values('%s','%s','%s','%s','%s','%s');",table_name,Username,name,Surname,date,Team,pos);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row corretly Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    /*** READ DATA FROM TABLE***/
    public void read_data(Connection conn, String table_name){
        Statement statement;
        ResultSet rs = null;
        try{
            String query=String.format("select * from %s;",table_name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("AthID")+" ");
                System.out.print(rs.getString("Username")+" ");
                System.out.println(rs.getString("Password")+" ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    /*** UPDATE DATA ***/
    public void update_name(Connection conn, String table_name, String old_name, String new_name){
        Statement statement;
        try{
            String query=String.format("update %s set Username='%s' where Username ='%s'",table_name,new_name,old_name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("CORRECTLY UPDATED");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    /*** SEARCH THE TABLE BY A VALUE***/
    public void search_by_name(Connection conn, String table_name, String username){
        Statement statement;
        ResultSet rs = null;
        try{
            String query=String.format("select * from %s where Username= '%s'",table_name,username);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("AthID")+" ");
                System.out.print(rs.getString("Username")+" ");
                System.out.println(rs.getString("Password")+" ");
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    /*** DELETE DATA FROM THE TABLE ***/
    public void delete_row_by_name(Connection conn, String table_name, String name){
        Statement statement;
        try{
            String query=String.format("delete from %s where Username= '%s'",table_name,name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    /*** DELETE TABLE ***/
    public void delete_table(Connection conn, String table_name){
        Statement statement;
        try{
            String query=String.format("drop table %s",table_name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public ResultSet getReservation(String username) {
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            resultSet=statement.executeQuery("select * from reservation_table where name= '"+username+"';");
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getAllReservation(String username) {
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            resultSet=statement.executeQuery("select * from reservation_table where trainer= '"+username+"';");
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }
}
