package citas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/citas_medicas";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Cambiar si tienes contraseña configurada

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
