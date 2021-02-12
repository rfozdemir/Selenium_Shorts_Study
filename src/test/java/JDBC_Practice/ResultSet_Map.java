package JDBC_Practice;

import Utility.DBUtility;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResultSet_Map {
    public static void main(String[] args) throws SQLException {
        String userName = "hr";
        String passWord = "hr";
        String url = "jdbc:oracle:thin:@54.162.168.188:1521:xe";
        //String sqlUpdate = "Update employees set first_name = 'Allan' where first_name='Furkan'";
        Connection connection = DriverManager.getConnection(url, userName, passWord);
        System.out.println("Connected");
        Statement statement = connection.createStatement();
        System.out.println("Statement is created");

       // statement.executeUpdate(sqlUpdate);
        ResultSet result = statement.executeQuery("select*from employees");
        System.out.println("Result Set is completed");

        Map<String, Integer> EmployeeInfo = new LinkedHashMap<>();
        while (result.next()) {
            String firstName = result.getString(2);
            String lastname = result.getString(3);
            int salary = result.getInt("salary");
            String fullName = firstName + " " + lastname;
            EmployeeInfo.put(fullName, salary);
//           if (salary == 9000) {
//                System.out.println(fullName + " is making 9000");
//            }
        }

        System.out.println(EmployeeInfo.get("Steven King"));




    }
}
