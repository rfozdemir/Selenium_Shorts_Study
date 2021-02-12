package JDBC_Practice;

import java.sql.*;

public class MetaData {
    //we two type of metadata ---> database metadata and resultset metadata
    public static void main(String[] args) throws SQLException {
        String userName = "hr";
        String passWord = "hr";
        String url = "jdbc:oracle:thin:@54.162.168.188:1521:xe";
        //String sqlUpdate = "Update employees set first_name = 'Allan' where first_name='Furkan'";
        Connection connection = DriverManager.getConnection(url, userName, passWord);
        System.out.println("Connected");
        Statement statement = connection.createStatement();
        System.out.println("Statement is created");
        DatabaseMetaData metaData=connection.getMetaData();
        System.out.println(metaData.getUserName());
        System.out.println(metaData.getDriverVersion());
        System.out.println(metaData.getDatabaseProductName());
        ResultSet rs=statement.executeQuery("select*from employees");

        ResultSetMetaData rsMetaData=rs.getMetaData();

        System.out.println( rsMetaData.getColumnCount()    );
        System.out.println(rsMetaData.getColumnName(2));
        System.out.println("======================");

       for(int i=1;i<=rsMetaData.getColumnCount();i++){
           System.out.println(rsMetaData.getColumnName(i));
       }

    }





}
