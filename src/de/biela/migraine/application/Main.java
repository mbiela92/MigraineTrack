package de.biela.migraine.application;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    static String jdbcURL = "jdbc:mysql://localhost:3306/migraine_db?useSSL=false&serverTimezone=UTC";
    static String jdbcUsername = "root";
    static String jdbcPassword = "";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Datenbankverbindung hergestellt");
        } catch (SQLException e) {
            // Auto-generated catch block
            e.printStackTrace();
            System.out.println("Fehler beim Verbindungsaufbau zur Datenbank");
        }
        return connection;
    }
    public static void main(String[] args) {
    }
}
