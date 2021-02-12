package JDBC_Practice;

import java.sql.*;

public class PrintingResult {
    public static void main(String[] args) throws SQLException {
        String userName = "hr";
        String passWord = "hr";
        String url = "jdbc:oracle:thin:@54.162.168.188:1521:xe";
        Connection connection = DriverManager.getConnection(url, userName, passWord);
        System.out.println("Connected");
        Statement statement = connection.createStatement();
        System.out.println("Statement is created");
        ResultSet result = statement.executeQuery("select*from employees");
        System.out.println("Result Set is completed");


        while(result.next()){
         // String firstName = result.getString("first_name");
            String firstName= result.getString(2);
            String lastname= result.getString(3);
            int salary= result.getInt("salary");
            System.out.println(firstName +" "+ lastname+" $"+salary);

        }



    }
}
