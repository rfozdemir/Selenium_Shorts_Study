package JDBC_Practice;

import Utility.ConfigurationReader;
import Utility.DBUtility;

import java.sql.*;

public class ResultSet_DataStructures {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from employees";
        ResultSet result = DBUtility.getResult(sql);

        while (result.next()) {
            String firstName = result.getString(1);
            String lastName = result.getString(2);
            //int salary=result.getInt("salary");
            String fullName = firstName + " " + lastName;
            System.out.println(fullName);

        }

        DBUtility.tearDown();

    }
}
