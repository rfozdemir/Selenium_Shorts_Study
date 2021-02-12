package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    public static Properties configFile;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            configFile = new Properties();
            configFile.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }

    public static void main(String[] args) {
        String url = getProperty("JDBC_URL");
        System.out.println(url);
        String username = getProperty("JDBC_UserName");
        String password = getProperty("JDBC_PassWord");
        System.out.println(username+" "+password);

    }

}
