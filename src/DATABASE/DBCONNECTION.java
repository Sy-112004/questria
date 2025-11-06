package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCONNECTION {
    private static final String URL = "jdbc:mysql://localhost:3306/questria?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "rootMySQL1234";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            System.out.println("Database connection failed" + e.getMessage());
            return null;
        }
    }
}
