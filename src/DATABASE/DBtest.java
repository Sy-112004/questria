package database;
import java.sql.Connection;

public class DBtest {
    public static void main(String [] args){
        Connection conn = database.DBCONNECTION.getConnection();
        if (conn !=null){
            System.out.println("test connection is working");
        }
    }

}

