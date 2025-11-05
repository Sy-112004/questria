package database;
import java.sql.Connection;

public class DbTest {
    public static void main(String [] args){
        Connection conn = DbConnection.getConnection();
        if (conn !=null){
            System.out.println("test connection is working");
        }
    }

}
