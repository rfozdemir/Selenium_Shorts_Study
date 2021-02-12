package JDBC_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleConnection {
    //JDBS java database connectivity
    /**
     1.Connection
     2.Statement
     3.ResultSet
     */
    public static void main(String[] args) throws SQLException {

        String userName="hr";
        String passWord="hr";
        String url = "jdbc:oracle:thin:@54.162.168.188:1521:xe";
        //'thin' specify your host name
        Connection connection=DriverManager.getConnection(url,userName,passWord);
        System.out.println("Connect Successfully");

    }


}
