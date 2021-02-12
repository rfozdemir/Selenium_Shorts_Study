package JDBC_Practice;

import java.sql.*;

public class Result_Set {
    public static void main(String[] args) throws SQLException {
        String userName = "hr";
        String passWord = "hr";
        String url = "jdbc:oracle:thin:@54.162.168.188:1521:xe";
        //'thin' specify your host name
        Connection connection = DriverManager.getConnection(url, userName, passWord);
        System.out.println("Connected");
        Statement statement = connection.createStatement();
        System.out.println("Statement is created");
        ResultSet result = statement.executeQuery("select*from employees");
        System.out.println("Result Set is completed");





        /**
         result.next();
         result.getString("ColumnName");
         result.getString("Index");
         result.getInt("ColumnName");
         result.getInt("Index");
         result.getDouble("ColumnName");
         result.getDouble("Index");
         result.getDate("ColumnName");
         result.getDate("Index");
         */


    }
}
