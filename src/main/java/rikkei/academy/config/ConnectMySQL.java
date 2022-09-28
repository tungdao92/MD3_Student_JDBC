package rikkei.academy.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySQL {
    static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/student1";
    private static final String USER = "root";
    private static final String PASSWORD = "anhtung12";
    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("keets nooi ok");
        } catch (ClassNotFoundException e) {
            System.out.println("That bai 1");
            throw new RuntimeException(e);
        }
        catch (SQLException e) {
            System.out.println("Thai bai 2");
            throw new RuntimeException(e);
        }
        return connection;
    }
}
