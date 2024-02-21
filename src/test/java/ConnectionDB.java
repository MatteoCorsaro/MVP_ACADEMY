
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionDB {
    public static void main(String[] args){
        //org.example.mvp_academy.Dao.ConnectionDB db=new org.example.mvp_academy.Dao.ConnectionDB();
        //db.connetc_to_db("MVP_ACADEMY","postgres","Matteoch01");
        //Connection conn=db.getConnection();
        //db.create_table(conn,"Athlete_table");
        //db.insert_row(conn, "Athlete_table","Corski","Matteo","Corsaro","22-Jun-2001","Morena", "Center");
        //db.insert_row(conn, "Athlete_table","Corsy007","Giacomo","Corsaro","8-Mar-2007","Guidonia", "Small Forward");
        //db.insert_row(conn, "Athlete_user","Corsy007","1234");
        //db.read_data(conn,"Athlete_user");
        //db.search_by_name(conn,"Athlete_user","Corski");
       /*LocalDate currentDate = LocalDate.now();
        int currentDay = currentDate.getDayOfMonth();
        System.out.println("Today is the " + currentDay + " day of the month.");*/
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
        ResultSet rs;
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
        ResultSet rs;
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

}
