package Utility;


import java.sql.*;

public class DBUtility {
    final static String username = ConfigurationReader.getProperty("JDBC_UserName"),
            password = ConfigurationReader.getProperty("JDBC_PassWord"),
            url = ConfigurationReader.getProperty("JDBC_URL");

    private static Connection connection;
    private static Statement statement;
    public static  DatabaseMetaData metaData;

    static {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            metaData=connection.getMetaData();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ResultSet getResult(String sql) {
        ResultSet result = null;
        try {
            result = statement.executeQuery(sql);

        } catch (Exception e) {

        }

        return result;
    }

    public static void tearDown() {
        //closes the connection at the last step
        try {
            connection.close();
        } catch (Exception e) {
        }


    }


    public static void Updating(String sql) {
        try {
            statement.executeUpdate(sql);

        } catch (SQLException e) {

        }


    }
}