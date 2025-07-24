package org.example;

import java.sql.*;

public class DataBaseConnection {
    String url="jdbc:mysql://localhost:3306/citas_medicas";
    String user="root";
    String pass="";

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    public void connectAndQuery() {
        try {
            myConn = DriverManager.getConnection(url, user, pass);
            System.out.println("Genial nos conectamos");

            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM users");

            while (myRs.next()) {
                System.out.println(myRs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Algo salio mal");
        } finally {
            try {
                if (myRs != null) myRs.close();
                if (myStmt != null) myStmt.close();
                if (myConn != null) myConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
