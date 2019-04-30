package by.epam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDaoFactory {
    private static Connection connection = null;

    public static Connection createConnection() {
        try {
            Class.forName(ConfigurationManager.getProperty("DRIVER"));
            connection = DriverManager.getConnection(ConfigurationManager.getProperty("URL"), ConfigurationManager.getProperty("USER"), ConfigurationManager.getProperty("PASSWORD"));
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}