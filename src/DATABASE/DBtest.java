package DATABASE;
import java.sql.Connection;

public class DBtest {
    public static void main(String [] args){
        Connection conn = DBCONNECTION.getConnection();
        if (conn !=null){
            System.out.println("test connection is working");
        }
    }

}
