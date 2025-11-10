package database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class DBtest {
    public static void main(String [] args){
        Connection conn = database.DBCONNECTION.getConnection();
        if (conn !=null){
            System.out.println("Connection is working");
            }


        }
    }




